package rs.raf.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: storage.proto")
public final class StorageServiceGrpc {

  private StorageServiceGrpc() {}

  public static final String SERVICE_NAME = "StorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<rs.raf.grpc.CommandRequest,
      rs.raf.grpc.CommandResponse> getSendCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendCommand",
      requestType = rs.raf.grpc.CommandRequest.class,
      responseType = rs.raf.grpc.CommandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.grpc.CommandRequest,
      rs.raf.grpc.CommandResponse> getSendCommandMethod() {
    io.grpc.MethodDescriptor<rs.raf.grpc.CommandRequest, rs.raf.grpc.CommandResponse> getSendCommandMethod;
    if ((getSendCommandMethod = StorageServiceGrpc.getSendCommandMethod) == null) {
      synchronized (StorageServiceGrpc.class) {
        if ((getSendCommandMethod = StorageServiceGrpc.getSendCommandMethod) == null) {
          StorageServiceGrpc.getSendCommandMethod = getSendCommandMethod = 
              io.grpc.MethodDescriptor.<rs.raf.grpc.CommandRequest, rs.raf.grpc.CommandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StorageService", "SendCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.grpc.CommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.grpc.CommandResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageServiceMethodDescriptorSupplier("SendCommand"))
                  .build();
          }
        }
     }
     return getSendCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.grpc.LogEntry,
      rs.raf.grpc.LogResponse> getAppendLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AppendLog",
      requestType = rs.raf.grpc.LogEntry.class,
      responseType = rs.raf.grpc.LogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.grpc.LogEntry,
      rs.raf.grpc.LogResponse> getAppendLogMethod() {
    io.grpc.MethodDescriptor<rs.raf.grpc.LogEntry, rs.raf.grpc.LogResponse> getAppendLogMethod;
    if ((getAppendLogMethod = StorageServiceGrpc.getAppendLogMethod) == null) {
      synchronized (StorageServiceGrpc.class) {
        if ((getAppendLogMethod = StorageServiceGrpc.getAppendLogMethod) == null) {
          StorageServiceGrpc.getAppendLogMethod = getAppendLogMethod = 
              io.grpc.MethodDescriptor.<rs.raf.grpc.LogEntry, rs.raf.grpc.LogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StorageService", "AppendLog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.grpc.LogEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.grpc.LogResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageServiceMethodDescriptorSupplier("AppendLog"))
                  .build();
          }
        }
     }
     return getAppendLogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.grpc.LeaderRequest,
      rs.raf.grpc.LeaderInfo> getGetLeaderInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLeaderInfo",
      requestType = rs.raf.grpc.LeaderRequest.class,
      responseType = rs.raf.grpc.LeaderInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.grpc.LeaderRequest,
      rs.raf.grpc.LeaderInfo> getGetLeaderInfoMethod() {
    io.grpc.MethodDescriptor<rs.raf.grpc.LeaderRequest, rs.raf.grpc.LeaderInfo> getGetLeaderInfoMethod;
    if ((getGetLeaderInfoMethod = StorageServiceGrpc.getGetLeaderInfoMethod) == null) {
      synchronized (StorageServiceGrpc.class) {
        if ((getGetLeaderInfoMethod = StorageServiceGrpc.getGetLeaderInfoMethod) == null) {
          StorageServiceGrpc.getGetLeaderInfoMethod = getGetLeaderInfoMethod = 
              io.grpc.MethodDescriptor.<rs.raf.grpc.LeaderRequest, rs.raf.grpc.LeaderInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StorageService", "GetLeaderInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.grpc.LeaderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.grpc.LeaderInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageServiceMethodDescriptorSupplier("GetLeaderInfo"))
                  .build();
          }
        }
     }
     return getGetLeaderInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StorageServiceStub newStub(io.grpc.Channel channel) {
    return new StorageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StorageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StorageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StorageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendCommand(rs.raf.grpc.CommandRequest request,
        io.grpc.stub.StreamObserver<rs.raf.grpc.CommandResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendCommandMethod(), responseObserver);
    }

    /**
     */
    public void appendLog(rs.raf.grpc.LogEntry request,
        io.grpc.stub.StreamObserver<rs.raf.grpc.LogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAppendLogMethod(), responseObserver);
    }

    /**
     */
    public void getLeaderInfo(rs.raf.grpc.LeaderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.grpc.LeaderInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLeaderInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendCommandMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.grpc.CommandRequest,
                rs.raf.grpc.CommandResponse>(
                  this, METHODID_SEND_COMMAND)))
          .addMethod(
            getAppendLogMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.grpc.LogEntry,
                rs.raf.grpc.LogResponse>(
                  this, METHODID_APPEND_LOG)))
          .addMethod(
            getGetLeaderInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.grpc.LeaderRequest,
                rs.raf.grpc.LeaderInfo>(
                  this, METHODID_GET_LEADER_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class StorageServiceStub extends io.grpc.stub.AbstractStub<StorageServiceStub> {
    private StorageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendCommand(rs.raf.grpc.CommandRequest request,
        io.grpc.stub.StreamObserver<rs.raf.grpc.CommandResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void appendLog(rs.raf.grpc.LogEntry request,
        io.grpc.stub.StreamObserver<rs.raf.grpc.LogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAppendLogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLeaderInfo(rs.raf.grpc.LeaderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.grpc.LeaderInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLeaderInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StorageServiceBlockingStub extends io.grpc.stub.AbstractStub<StorageServiceBlockingStub> {
    private StorageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public rs.raf.grpc.CommandResponse sendCommand(rs.raf.grpc.CommandRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendCommandMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.grpc.LogResponse appendLog(rs.raf.grpc.LogEntry request) {
      return blockingUnaryCall(
          getChannel(), getAppendLogMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.grpc.LeaderInfo getLeaderInfo(rs.raf.grpc.LeaderRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLeaderInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StorageServiceFutureStub extends io.grpc.stub.AbstractStub<StorageServiceFutureStub> {
    private StorageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.grpc.CommandResponse> sendCommand(
        rs.raf.grpc.CommandRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendCommandMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.grpc.LogResponse> appendLog(
        rs.raf.grpc.LogEntry request) {
      return futureUnaryCall(
          getChannel().newCall(getAppendLogMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.grpc.LeaderInfo> getLeaderInfo(
        rs.raf.grpc.LeaderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLeaderInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_COMMAND = 0;
  private static final int METHODID_APPEND_LOG = 1;
  private static final int METHODID_GET_LEADER_INFO = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_COMMAND:
          serviceImpl.sendCommand((rs.raf.grpc.CommandRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.grpc.CommandResponse>) responseObserver);
          break;
        case METHODID_APPEND_LOG:
          serviceImpl.appendLog((rs.raf.grpc.LogEntry) request,
              (io.grpc.stub.StreamObserver<rs.raf.grpc.LogResponse>) responseObserver);
          break;
        case METHODID_GET_LEADER_INFO:
          serviceImpl.getLeaderInfo((rs.raf.grpc.LeaderRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.grpc.LeaderInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rs.raf.grpc.Storage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StorageService");
    }
  }

  private static final class StorageServiceFileDescriptorSupplier
      extends StorageServiceBaseDescriptorSupplier {
    StorageServiceFileDescriptorSupplier() {}
  }

  private static final class StorageServiceMethodDescriptorSupplier
      extends StorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StorageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StorageServiceFileDescriptorSupplier())
              .addMethod(getSendCommandMethod())
              .addMethod(getAppendLogMethod())
              .addMethod(getGetLeaderInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
