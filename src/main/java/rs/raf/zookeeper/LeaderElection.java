package rs.raf.zookeeper;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import rs.raf.Connection;
import rs.raf.StorageMapService;
import rs.raf.grpc.StorageServiceGrpc;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rs.raf.Main.APP_ROOT_NAME;
import static rs.raf.Main.NODE_PREFIX;

@Slf4j
@AllArgsConstructor
public class LeaderElection {
    public static final int REPLICA_NODE_SEQUENCE_INDEX = APP_ROOT_NAME.length() + NODE_PREFIX.length() - 1;

    private final Node node;
    private final ZooKeeper zooKeeper;
    private final StorageMapService storageMapService;

    public void setLeader(List<String> nodeList) {
        try {
            node.setRole(Role.LEADER);
            setFollowersChannels(nodeList);
            // Lider prati ako se novi cvor povezao u u grupu
            // Da bi ga dodao u svoju listu za replikaciju log-a
            zooKeeper.getChildren(node.getRoot(), true);

            storageMapService.setServerState(true);
            log.info("I am leader");
        } catch (KeeperException | InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private void setFollowersChannels(List<String> nodeList) {
        Map<String, FollowerChannel> oldMap = node.getFollowersChannelMap();
        node.setFollowersChannelMap(new HashMap<>());

        for (int i = 1; i < nodeList.size(); i++) {
            String nodeName = nodeList.get(i);
            FollowerChannel followerChannel = oldMap.get(nodeName);

            try {
                if (followerChannel == null) {
                    byte[] data = zooKeeper.getData(node.getRoot() + "/" + nodeName, false, null);
                    Connection connection = Connection.deserialize(data);
                    ManagedChannel channel = ManagedChannelBuilder.forAddress(connection.getIpAddress(), connection.getPort())
                            .usePlaintext()
                            .build();

                    StorageServiceGrpc.StorageServiceBlockingStub blockingStub = StorageServiceGrpc.newBlockingStub(channel);
                    followerChannel = new FollowerChannel(nodeName, connection, blockingStub);
                } else {
                    oldMap.remove(nodeName);
                }
                node.getFollowersChannelMap().put(nodeName, followerChannel);
            } catch (KeeperException | InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }

    private void checkReplicaCandidate() {
        try {
            List<String> list = zooKeeper.getChildren(node.getRoot(), false);
            log.info("There are total: {} replicas for elections\n{}", list.size(), list);

            if (list.size() == 0) {
                log.info("0 nodes found");
            } else {
                Collections.sort(list);
                int myIndex = -1;

                for (int i = 0; i < list.size(); i++) {
                    Integer tempValue = Integer.parseInt(list.get(i).substring(NODE_PREFIX.length()-1));
                    if (node.getId().equals(tempValue)) {
                        myIndex = i;
                        break;
                    }
                }
                if (myIndex == 0) {
                    log.info("Setting new leader");
                    setLeader(list);
                } else {
                    String totalLeader = list.get(0);
                    byte[] data = zooKeeper.getData(node.getRoot() + "/" + totalLeader, false, null);
                    node.setLeaderConnection(Connection.deserialize(data));

                    String myLeaderNodeToWatch = list.get(myIndex - 1);
                    data = zooKeeper.getData(node.getRoot() + "/" + myLeaderNodeToWatch, true, null);
                    //Stat stat = zk.exists(root + "/" + myLeaderNodeToWatch, true);
                    //if (stat == null)
                    //	setLeader();
                }
            }
        } catch (KeeperException | InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public void election() {
        checkReplicaCandidate();
    }
}
