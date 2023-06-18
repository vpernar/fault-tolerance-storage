package rs.raf.zookeeper;

import com.google.protobuf.ByteString;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import rs.raf.Connection;
import rs.raf.StorageMapService;
import rs.raf.exceptions.PrefixException;
import rs.raf.grpc.LogEntry;
import rs.raf.grpc.LogResponse;
import rs.raf.grpc.LogStatus;
import rs.raf.grpc.StorageServiceGrpc;
import rs.raf.log.ReplicatedLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static rs.raf.Main.*;
import static rs.raf.log.ReplicatedLog.FILE_LOCK;
import static rs.raf.log.SnapshotScheduler.SNAPSHOT_PATH;

@Slf4j
@Getter
@Setter
public class Node extends SyncPrimitive implements Runnable {
    private final String root;
    private final Connection connection;
    private final StorageMapService storageMapService;
    private Connection leaderConnection;
    private Integer id;
    private volatile Role role;
    private Map<String, FollowerChannel> followersChannelMap = new HashMap<>();
    private volatile boolean running = false;
    private Thread thread = null;
    private final LeaderElection leaderElection;


    public Node(String address, String root, Connection connection, StorageMapService storageMapService) {
        super(address, root);
        this.connection = connection;
        this.root = root;
        this.storageMapService = storageMapService;
        leaderElection = new LeaderElection(this, zooKeeper, storageMapService);

        createZNode();
        storageMapService.setStorage(readSnapshot());
        readLogs();
    }

    private void readLogs() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(LOG_PATH));

            String line;
            Long lastEntryIndex = -1L;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");

                if (parts.length >= 3) {
                    lastEntryIndex = Long.parseLong(parts[0]);
                    String command = parts[1];
                    String key = parts[2];
                    String value = (parts.length > 3) ? parts[3] : "";

                    if (command.equalsIgnoreCase("PUT")) {
                        storageMapService.put(key, value);
                    } else {
                        storageMapService.remove(key);
                    }
                }
            }

            reader.close();
            ReplicatedLog.lastEntryIndex = lastEntryIndex;
        } catch (IOException e) {
            log.error("Error reading the file: {}", e.getMessage());
        }
    }

    private void createZNode() {
        try {
            if (zooKeeper != null) {
                createRootNode();
            }

            // Kreira svoj cvor gde je value hostName:grpcPort kako bi mu pristupao lider
            String nodeName = zooKeeper.create(root + NODE_PREFIX, // path
                    Connection.serialize(connection), // byte[] data
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);

            log.info("Node election name: {}", nodeName);
            if (nodeName.startsWith(APP_ROOT_NAME + NODE_PREFIX)) {
                System.out.println("NODE NAME: " + nodeName);
                String idPart = nodeName.substring(APP_ROOT_NAME.length() + NODE_PREFIX.length());
                id = Integer.parseInt(idPart);
                System.out.println("ID PART: " + id);
                log.info("Node election id: {}", id);
            } else {
                throw new PrefixException("Prefix not found");
            }
        } catch (KeeperException | InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private void createRootNode() {
        try {
            // Da li postoji znode sa odredjenom putanjom u ZooKeeper hijerarhiji
            Stat stat = zooKeeper.exists(root, false);
            if (stat == null) {
                // Ako ne postoji pravimo root cvor koji je persistant
                zooKeeper.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (KeeperException | InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public void replicateLogs(ReplicatedLog replicatedLog) {
        synchronized (this) {
            replicatedLog.appendToLocalLog();

            LogEntry logEntry = LogEntry.newBuilder()
                    .setEntryAtIndex(replicatedLog.getLogEntryIndex())
                    .setLogEntryData(ByteString.copyFromUtf8(replicatedLog.toString()))
                    .build();

            for (FollowerChannel channel : followersChannelMap.values()) {
                LogResponse logResponse = channel.getBlockingStub().appendLog(logEntry);
                if (logResponse.getLastEntryIndex() != ReplicatedLog.lastEntryIndex) {
                    sendMissingLogs(channel.getBlockingStub(), logResponse.getLastEntryIndex());
                }
            }
        }
    }

    private void sendMissingLogs(StorageServiceGrpc.StorageServiceBlockingStub blockingStub, Long lastIndex) {
        FILE_LOCK.readLock().lock();
        try {
            log.info("Reading missing logs");
            FileReader fileReader = new FileReader(LOG_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                ReplicatedLog replicatedLog = ReplicatedLog.logFromString(line);
                if (replicatedLog.getLogEntryIndex() > lastIndex) {
                    LogEntry logEntry = LogEntry.newBuilder()
                            .setEntryAtIndex(replicatedLog.getLogEntryIndex())
                            .setLogEntryData(ByteString.copyFromUtf8(replicatedLog.toString()))
                            .build();

                    blockingStub.appendLog(logEntry);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            log.error("Error reading the file: {}", e.getMessage());
        } finally {
            FILE_LOCK.readLock().unlock();
        }
    }

    private Map<String, String> readSnapshot() {
        Map<String, String> dataMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(SNAPSHOT_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    dataMap.put(key, value);
                }
            }
        } catch (IOException e) {
            log.error("Error reading the file: {}", e.getMessage());
        }

        log.info("Inserted map from snapshot: {}", dataMap);
        return dataMap;
    }

    public LogResponse appendLog(ReplicatedLog replicatedLog) {
        System.out.println("======= APPEND LOG =======\n" + replicatedLog);
        if (ReplicatedLog.lastEntryIndex < 0) ReplicatedLog.lastEntryIndex = 0L;

        if (replicatedLog.getLogEntryIndex() - 1 != ReplicatedLog.lastEntryIndex) {
            return LogResponse.newBuilder()
                    .setEntryAtIndex(ReplicatedLog.lastEntryIndex)
                    .setLastEntryIndex(ReplicatedLog.lastEntryIndex)
                    .setStatus(LogStatus.LOG_NO_LAST_ENTRY)
                    .build();
        }

        String command = replicatedLog.getCommand();
        replicatedLog.appendToLocalLog();

        if (command.equalsIgnoreCase("PUT")) {
            storageMapService.put(replicatedLog.getKey(), replicatedLog.getValue());
        } else if (command.equalsIgnoreCase("DELETE")) {
            storageMapService.remove(replicatedLog.getKey());
        }

        return LogResponse.newBuilder()
                .setEntryAtIndex(replicatedLog.getLogEntryIndex())
                .setLastEntryIndex(ReplicatedLog.lastEntryIndex)
                .setStatus(LogStatus.LOG_OK)
                .build();
    }

    public boolean isLeader() {
        return role.equals(Role.LEADER);
    }

    @Override
    public void run() {
        while (running) {
            synchronized (mutex) {
                try {
                    mutex.wait();
                    log.info("Notification from configuration");
                    leaderElection.election();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    public void start() {
        running = true;
//        if (!running) {
//            thread = new Thread(this, "Node");
//            running = true;
//            thread.start();
        while (running) {
            leaderElection.election();
            synchronized (mutex) {
                try {
                    mutex.wait();
                    log.info("Notification from configuration");
                    leaderElection.election();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    public void stop() {
        Thread stopThread = thread;
        thread = null;
        running = false;
        stopThread.interrupt();
    }
}

