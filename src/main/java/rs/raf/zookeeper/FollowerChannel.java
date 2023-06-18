package rs.raf.zookeeper;

import lombok.AllArgsConstructor;
import lombok.Data;
import rs.raf.Connection;
import rs.raf.grpc.StorageServiceGrpc;

@Data
@AllArgsConstructor
public class FollowerChannel {
    private final String node;
    private final Connection connection;
    private final StorageServiceGrpc.StorageServiceBlockingStub blockingStub;


}
