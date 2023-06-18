package rs.raf.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import rs.raf.Connection;
import rs.raf.grpc.*;
import rs.raf.zookeeper.SyncPrimitive;

import java.util.*;

import static rs.raf.zookeeper.LeaderElection.REPLICA_NODE_SEQUENCE_INDEX;

@Slf4j
public class Client extends SyncPrimitive {
    private final String root;
    private String leaderNodeName = null;
    private Connection leaderConnection;

    private ManagedChannel channel = null;
    private StorageServiceGrpc.StorageServiceBlockingStub blockingStub = null;

    public Client(String address, String root) {
        super(address, root);
        this.root = root;
    }

    @Override
    public void process(WatchedEvent event) {
        try {
            checkLeader();
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void checkLeader() throws KeeperException, InterruptedException {
        Thread.sleep(100);
        List<String> list = zooKeeper.getChildren(root, false);
        log.info("There are total: {} replicas for elections!\n{}", list.size(), list);

        if (list.size() == 0) {
            log.info("0 Nodes found");
        } else {
            int minValue = Integer.parseInt(list.get(0).substring(REPLICA_NODE_SEQUENCE_INDEX));
            String minNodeName = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                int tempValue = Integer.parseInt(list.get(i).substring(REPLICA_NODE_SEQUENCE_INDEX));
                if (minValue > tempValue) {
                    minValue = tempValue;
                    minNodeName = list.get(i);
                }
            }

            if (!minNodeName.equals(leaderNodeName)) {
                leaderNodeName = minNodeName;
                byte[] data = zooKeeper.getData(root + "/" + leaderNodeName, true, null);
                leaderConnection = Connection.deserialize(data);

                log.info("Leader is " + leaderNodeName);

                blockingStub = getBlockingStub(leaderConnection);
            }
        }
    }

    public StorageServiceGrpc.StorageServiceBlockingStub getBlockingStub(Connection connection) {
        channel = ManagedChannelBuilder.forAddress(connection.getIpAddress(), connection.getPort())
                .usePlaintext()
                .build();

        return StorageServiceGrpc.newBlockingStub(channel);
    }

    public void start() {
        CommandRequest request;
        CommandResponse response;
        CommandRequestType command;

        Random random = new Random();
        String key, value;
        int vflag;
        long ms;

        int ci;
        List<CommandRequestType> commands = new ArrayList<>(
                List.of(CommandRequestType.GET, CommandRequestType.PUT, CommandRequestType.DELETE));

        for (int i = 0; i < 100; i++) {
            ms = random.nextLong(1000, 2000);
            ci = random.nextInt(0,3);

            command = commands.get(ci);
            key = String.valueOf(random.nextInt(0, 20));
            value = UUID.randomUUID().toString();

            log.info("Leader is: {}", leaderNodeName);

            if (!command.equals(CommandRequestType.PUT)) {
                request = CommandRequest.newBuilder()
                        .setOpType(command)
                        .setKey(key)
                        .setValue("")
                        .build();
            } else {
                request = CommandRequest.newBuilder()
                        .setOpType(command)
                        .setKey(key)
                        .setValue(value)
                        .build();
            }

            System.out.println("-------- REQUEST --------");
            System.out.println("COMMAND: " + command);
            System.out.println("KEY: " + key);
            System.out.println("VALUE: " + value);
            synchronized (this) {
                response = blockingStub.sendCommand(request);
            }
            printReqResp(response, request);
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }

    public static void printReqResp(CommandResponse response, CommandRequest request) {
        if (response.getStatus() == RequestStatus.STATUS_OK) {
            log.info("Status OK! request = {}, , response =  key:{}, value: {}", request.getOpType(), request.getKey(), response.getValue());
        } else if (response.getStatus() == RequestStatus.UPDATE_REJECTED_NOT_LEADER) {
            log.info("Update rejected not leader! {} {} {}", request.getOpType(), request.getKey(), request.getValue());
        } else {
            log.error("Error: {} {} {} ", request.getOpType(), request.getKey(), request.getValue());
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
