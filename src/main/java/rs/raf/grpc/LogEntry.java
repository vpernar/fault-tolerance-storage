// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: storage.proto

package rs.raf.grpc;

/**
 * Protobuf type {@code LogEntry}
 */
public  final class LogEntry extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LogEntry)
    LogEntryOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LogEntry.newBuilder() to construct.
  private LogEntry(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogEntry() {
    logEntryData_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LogEntry();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LogEntry(
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

            entryAtIndex_ = input.readUInt64();
            break;
          }
          case 18: {

            logEntryData_ = input.readBytes();
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
    return rs.raf.grpc.Storage.internal_static_LogEntry_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.grpc.Storage.internal_static_LogEntry_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.grpc.LogEntry.class, rs.raf.grpc.LogEntry.Builder.class);
  }

  public static final int ENTRYATINDEX_FIELD_NUMBER = 1;
  private long entryAtIndex_;
  /**
   * <code>uint64 entryAtIndex = 1;</code>
   * @return The entryAtIndex.
   */
  public long getEntryAtIndex() {
    return entryAtIndex_;
  }

  public static final int LOGENTRYDATA_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString logEntryData_;
  /**
   * <code>bytes logEntryData = 2;</code>
   * @return The logEntryData.
   */
  public com.google.protobuf.ByteString getLogEntryData() {
    return logEntryData_;
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
    if (entryAtIndex_ != 0L) {
      output.writeUInt64(1, entryAtIndex_);
    }
    if (!logEntryData_.isEmpty()) {
      output.writeBytes(2, logEntryData_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (entryAtIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, entryAtIndex_);
    }
    if (!logEntryData_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, logEntryData_);
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
    if (!(obj instanceof rs.raf.grpc.LogEntry)) {
      return super.equals(obj);
    }
    rs.raf.grpc.LogEntry other = (rs.raf.grpc.LogEntry) obj;

    if (getEntryAtIndex()
        != other.getEntryAtIndex()) return false;
    if (!getLogEntryData()
        .equals(other.getLogEntryData())) return false;
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
    hash = (37 * hash) + ENTRYATINDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getEntryAtIndex());
    hash = (37 * hash) + LOGENTRYDATA_FIELD_NUMBER;
    hash = (53 * hash) + getLogEntryData().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.grpc.LogEntry parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.grpc.LogEntry parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.grpc.LogEntry parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.grpc.LogEntry parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.grpc.LogEntry parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.grpc.LogEntry parseFrom(
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
  public static Builder newBuilder(rs.raf.grpc.LogEntry prototype) {
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
   * Protobuf type {@code LogEntry}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LogEntry)
      rs.raf.grpc.LogEntryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.grpc.Storage.internal_static_LogEntry_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.grpc.Storage.internal_static_LogEntry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.grpc.LogEntry.class, rs.raf.grpc.LogEntry.Builder.class);
    }

    // Construct using rs.raf.grpc.LogEntry.newBuilder()
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
      entryAtIndex_ = 0L;

      logEntryData_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.grpc.Storage.internal_static_LogEntry_descriptor;
    }

    @java.lang.Override
    public rs.raf.grpc.LogEntry getDefaultInstanceForType() {
      return rs.raf.grpc.LogEntry.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.grpc.LogEntry build() {
      rs.raf.grpc.LogEntry result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.grpc.LogEntry buildPartial() {
      rs.raf.grpc.LogEntry result = new rs.raf.grpc.LogEntry(this);
      result.entryAtIndex_ = entryAtIndex_;
      result.logEntryData_ = logEntryData_;
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
      if (other instanceof rs.raf.grpc.LogEntry) {
        return mergeFrom((rs.raf.grpc.LogEntry)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.grpc.LogEntry other) {
      if (other == rs.raf.grpc.LogEntry.getDefaultInstance()) return this;
      if (other.getEntryAtIndex() != 0L) {
        setEntryAtIndex(other.getEntryAtIndex());
      }
      if (other.getLogEntryData() != com.google.protobuf.ByteString.EMPTY) {
        setLogEntryData(other.getLogEntryData());
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
      rs.raf.grpc.LogEntry parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (rs.raf.grpc.LogEntry) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long entryAtIndex_ ;
    /**
     * <code>uint64 entryAtIndex = 1;</code>
     * @return The entryAtIndex.
     */
    public long getEntryAtIndex() {
      return entryAtIndex_;
    }
    /**
     * <code>uint64 entryAtIndex = 1;</code>
     * @param value The entryAtIndex to set.
     * @return This builder for chaining.
     */
    public Builder setEntryAtIndex(long value) {
      
      entryAtIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 entryAtIndex = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearEntryAtIndex() {
      
      entryAtIndex_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString logEntryData_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes logEntryData = 2;</code>
     * @return The logEntryData.
     */
    public com.google.protobuf.ByteString getLogEntryData() {
      return logEntryData_;
    }
    /**
     * <code>bytes logEntryData = 2;</code>
     * @param value The logEntryData to set.
     * @return This builder for chaining.
     */
    public Builder setLogEntryData(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      logEntryData_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes logEntryData = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLogEntryData() {
      
      logEntryData_ = getDefaultInstance().getLogEntryData();
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


    // @@protoc_insertion_point(builder_scope:LogEntry)
  }

  // @@protoc_insertion_point(class_scope:LogEntry)
  private static final rs.raf.grpc.LogEntry DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.grpc.LogEntry();
  }

  public static rs.raf.grpc.LogEntry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogEntry>
      PARSER = new com.google.protobuf.AbstractParser<LogEntry>() {
    @java.lang.Override
    public LogEntry parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LogEntry(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogEntry> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogEntry> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.grpc.LogEntry getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

