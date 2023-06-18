package rs.raf;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import rs.raf.grpc.*;
import rs.raf.log.ReplicatedLog;
import rs.raf.zookeeper.Node;

@Data
@Slf4j
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StorageServiceGrpcServer extends StorageServiceGrpc.StorageServiceImplBase {
    private final StorageMapService storageMapService;
    private final Node node;

    @Override
    public void sendCommand(CommandRequest request, StreamObserver<CommandResponse> responseObserver) {
        CommandResponse response;
        String command = request.getOpType().toString();
        String key = request.getKey();
        String value = request.getValue();

        if (command.equals(CommandRequestType.PUT.toString())) {
            if (!node.isLeader()) {
                response = CommandResponse.newBuilder()
                        .setStatus(RequestStatus.UPDATE_REJECTED_NOT_LEADER)
                        .build();

            } else {
                ReplicatedLog log = new ReplicatedLog(command, key, value);
//                Thread thread = new Thread(() -> node.replicateLogs(log));
//                thread.start();
                node.replicateLogs(log);

                storageMapService.put(key, value);
                response = CommandResponse.newBuilder()
                        .setStatus(RequestStatus.STATUS_OK)
                        .setKey(key)
                        .setValue(value)
                        .build();
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } else if (command.equals(CommandRequestType.DELETE.toString())) {
            if (!node.isLeader()) {
                response = CommandResponse.newBuilder()
                        .setStatus(RequestStatus.UPDATE_REJECTED_NOT_LEADER)
                        .build();

            } else {
                ReplicatedLog log = new ReplicatedLog(command, key, value);
//                Thread thread = new Thread(() -> node.replicateLogs(log));
//                thread.start();
                node.replicateLogs(log);

                storageMapService.remove(request.getKey());
                response = CommandResponse.newBuilder()
                        .setStatus(RequestStatus.STATUS_OK)
                        .setKey(key)
                        .setValue(value)
                        .build();
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } else if (command.equals(CommandRequestType.GET.toString())) {

            storageMapService.get(request.getKey());
            response = CommandResponse.newBuilder()
                    .setStatus(RequestStatus.STATUS_OK)
                    .setKey(key)
                    .setValue(value)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void appendLog(LogEntry request, StreamObserver<LogResponse> responseObserver) {
        ReplicatedLog replicatedLog = ReplicatedLog.logFromString(
                new String(request.getLogEntryData().toByteArray()));

        LogResponse response = node.appendLog(replicatedLog);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getLeaderInfo(LeaderRequest request, StreamObserver<LeaderInfo> responseObserver) {
        LeaderInfo leader;

        if (node.isLeader()) {
            leader = LeaderInfo.newBuilder()
                    .setImLeader(true)
                    .setConnection(ByteString.copyFrom(Connection.serialize(node.getConnection())))
                    .build();
        } else {
            leader = LeaderInfo.newBuilder()
                    .setImLeader(false)
                    .setConnection(ByteString.copyFrom(Connection.serialize(node.getConnection())))
                    .build();
        }

        responseObserver.onNext(leader);
        responseObserver.onCompleted();
    }
}
