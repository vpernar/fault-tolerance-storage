package rs.raf;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.zookeeper.KeeperException;
import rs.raf.client.Client;
import rs.raf.exceptions.PrefixException;
import rs.raf.exceptions.SerializationException;
import rs.raf.log.SnapshotScheduler;
import rs.raf.zookeeper.Node;

import java.io.IOException;

public class Main {
    public static final String APP_ROOT_NAME = "/storage";
    public static final String NODE_PREFIX = "/node_";
    public static String LOG_PATH;

    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Wrong arguments. Please use <ip address:zookeeper port> <server port> <log file path> <client/server>");
            System.exit(1);
        }

        try {
            String zookeeperAddress = args[0];
            Integer serverPort = Integer.valueOf(args[1]);
            LOG_PATH = args[2];
            String appMode = args[3];

            Connection connection = new Connection("127.0.0.1", serverPort);

            if (appMode.equalsIgnoreCase("server")) {
                StorageMapService storageMapService = new StorageMapService();
                SnapshotScheduler snapshotScheduler = new SnapshotScheduler(storageMapService);
                snapshotScheduler.start();
                Node node = new Node(zookeeperAddress, APP_ROOT_NAME, connection, storageMapService);

                Server gRPCServer = ServerBuilder
                        .forPort(serverPort)
                        .addService(new StorageServiceGrpcServer(storageMapService, node)).build();
                gRPCServer.start();

                node.start();

                gRPCServer.awaitTermination();

                node.stop();
            } else if (appMode.equalsIgnoreCase("client")) {
                Client client = new Client(zookeeperAddress, APP_ROOT_NAME);
                client.checkLeader();
                client.start();

            } else {
                System.err.println("Unknown application mode. Please use server or clinet!");
                System.exit(1);
            }
        } catch (InterruptedException | KeeperException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Please enter port as number");
        } catch (SerializationException | IOException e) {
            System.err.println(e.getMessage());
        } catch (PrefixException e) {
            System.err.println("Problem with serialization: " + e.getMessage());
        }
    }
}