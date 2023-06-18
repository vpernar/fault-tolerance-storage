// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: storage.proto

package rs.raf.grpc;

/**
 * Protobuf type {@code LogResponse}
 */
public  final class LogResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LogResponse)
    LogResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LogResponse.newBuilder() to construct.
  private LogResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogResponse() {
    status_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LogResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LogResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 16: {

            entryAtIndex_ = input.readUInt64();
            break;
          }
          case 24: {

            lastEntryIndex_ = input.readUInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.grpc.Storage.internal_static_LogResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.grpc.Storage.internal_static_LogResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.grpc.LogResponse.class, rs.raf.grpc.LogResponse.Builder.class);
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_;
  /**
   * <code>.LogStatus status = 1;</code>
   * @return The enum numeric value on the wire for status.
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.LogStatus status = 1;</code>
   * @return The status.
   */
  public rs.raf.grpc.LogStatus getStatus() {
    @SuppressWarnings("deprecation")
    rs.raf.grpc.LogStatus result = rs.raf.grpc.LogStatus.valueOf(status_);
    return result == null ? rs.raf.grpc.LogStatus.UNRECOGNIZED : result;
  }

  public static final int ENTRYATINDEX_FIELD_NUMBER = 2;
  private long entryAtIndex_;
  /**
   * <code>uint64 entryAtIndex = 2;</code>
   * @return The entryAtIndex.
   */
  public long getEntryAtIndex() {
    return entryAtIndex_;
  }

  public static final int LASTENTRYINDEX_FIELD_NUMBER = 3;
  private long lastEntryIndex_;
  /**
   * <code>uint64 lastEntryIndex = 3;</code>
   * @return The lastEntryIndex.
   */
  public long getLastEntryIndex() {
    return lastEntryIndex_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (status_ != rs.raf.grpc.LogStatus.LOG_OK.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (entryAtIndex_ != 0L) {
      output.writeUInt64(2, entryAtIndex_);
    }
    if (lastEntryIndex_ != 0L) {
      output.writeUInt64(3, lastEntryIndex_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != rs.raf.grpc.LogStatus.LOG_OK.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (entryAtIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, entryAtIndex_);
    }
    if (lastEntryIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, lastEntryIndex_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof rs.raf.grpc.LogResponse)) {
      return super.equals(obj);
    }
    rs.raf.grpc.LogResponse other = (rs.raf.grpc.LogResponse) obj;

    if (status_ != other.status_) return false;
    if (getEntryAtIndex()
        != other.getEntryAtIndex()) return false;
    if (getLastEntryIndex()
        != other.getLastEntryIndex()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + ENTRYATINDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getEntryAtIndex());
    hash = (37 * hash) + LASTENTRYINDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastEntryIndex());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.grpc.LogResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.grpc.LogResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.grpc.LogResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.grpc.LogResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.grpc.LogResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.grpc.LogResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(rs.raf.grpc.LogResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code LogResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LogResponse)
      rs.raf.grpc.LogResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.grpc.Storage.internal_static_LogResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.grpc.Storage.internal_static_LogResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.grpc.LogResponse.class, rs.raf.grpc.LogResponse.Builder.class);
    }

    // Construct using rs.raf.grpc.LogResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      status_ = 0;

      entryAtIndex_ = 0L;

      lastEntryIndex_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.grpc.Storage.internal_static_LogResponse_descriptor;
    }

    @java.lang.Override
    public rs.raf.grpc.LogResponse getDefaultInstanceForType() {
      return rs.raf.grpc.LogResponse.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.grpc.LogResponse build() {
      rs.raf.grpc.LogResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.grpc.LogResponse buildPartial() {
      rs.raf.grpc.LogResponse result = new rs.raf.grpc.LogResponse(this);
      result.status_ = status_;
      result.entryAtIndex_ = entryAtIndex_;
      result.lastEntryIndex_ = lastEntryIndex_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof rs.raf.grpc.LogResponse) {
        return mergeFrom((rs.raf.grpc.LogResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.grpc.LogResponse other) {
      if (other == rs.raf.grpc.LogResponse.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.getEntryAtIndex() != 0L) {
        setEntryAtIndex(other.getEntryAtIndex());
      }
      if (other.getLastEntryIndex() != 0L) {
        setLastEntryIndex(other.getLastEntryIndex());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      rs.raf.grpc.LogResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (rs.raf.grpc.LogResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.LogStatus status = 1;</code>
     * @return The enum numeric value on the wire for status.
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.LogStatus status = 1;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.LogStatus status = 1;</code>
     * @return The status.
     */
    public rs.raf.grpc.LogStatus getStatus() {
      @SuppressWarnings("deprecation")
      rs.raf.grpc.LogStatus result = rs.raf.grpc.LogStatus.valueOf(status_);
      return result == null ? rs.raf.grpc.LogStatus.UNRECOGNIZED : result;
    }
    /**
     * <code>.LogStatus status = 1;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(rs.raf.grpc.LogStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.LogStatus status = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private long entryAtIndex_ ;
    /**
     * <code>uint64 entryAtIndex = 2;</code>
     * @return The entryAtIndex.
     */
    public long getEntryAtIndex() {
      return entryAtIndex_;
    }
    /**
     * <code>uint64 entryAtIndex = 2;</code>
     * @param value The entryAtIndex to set.
     * @return This builder for chaining.
     */
    public Builder setEntryAtIndex(long value) {
      
      entryAtIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 entryAtIndex = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearEntryAtIndex() {
      
      entryAtIndex_ = 0L;
      onChanged();
      return this;
    }

    private long lastEntryIndex_ ;
    /**
     * <code>uint64 lastEntryIndex = 3;</code>
     * @return The lastEntryIndex.
     */
    public long getLastEntryIndex() {
      return lastEntryIndex_;
    }
    /**
     * <code>uint64 lastEntryIndex = 3;</code>
     * @param value The lastEntryIndex to set.
     * @return This builder for chaining.
     */
    public Builder setLastEntryIndex(long value) {
      
      lastEntryIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 lastEntryIndex = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastEntryIndex() {
      
      lastEntryIndex_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:LogResponse)
  }

  // @@protoc_insertion_point(class_scope:LogResponse)
  private static final rs.raf.grpc.LogResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.grpc.LogResponse();
  }

  public static rs.raf.grpc.LogResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogResponse>
      PARSER = new com.google.protobuf.AbstractParser<LogResponse>() {
    @java.lang.Override
    public LogResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LogResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.grpc.LogResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

