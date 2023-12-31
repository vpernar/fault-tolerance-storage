// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: storage.proto

package rs.raf.grpc;

/**
 * Protobuf enum {@code RequestStatus}
 */
public enum RequestStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>STATUS_OK = 0;</code>
   */
  STATUS_OK(0),
  /**
   * <code>UPDATE_REJECTED_NOT_LEADER = 1;</code>
   */
  UPDATE_REJECTED_NOT_LEADER(1),
  /**
   * <code>VALUE_FOR_KEY_NOT_FOUND = 2;</code>
   */
  VALUE_FOR_KEY_NOT_FOUND(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>STATUS_OK = 0;</code>
   */
  public static final int STATUS_OK_VALUE = 0;
  /**
   * <code>UPDATE_REJECTED_NOT_LEADER = 1;</code>
   */
  public static final int UPDATE_REJECTED_NOT_LEADER_VALUE = 1;
  /**
   * <code>VALUE_FOR_KEY_NOT_FOUND = 2;</code>
   */
  public static final int VALUE_FOR_KEY_NOT_FOUND_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static RequestStatus valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static RequestStatus forNumber(int value) {
    switch (value) {
      case 0: return STATUS_OK;
      case 1: return UPDATE_REJECTED_NOT_LEADER;
      case 2: return VALUE_FOR_KEY_NOT_FOUND;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<RequestStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      RequestStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<RequestStatus>() {
          public RequestStatus findValueByNumber(int number) {
            return RequestStatus.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return rs.raf.grpc.Storage.getDescriptor().getEnumTypes().get(1);
  }

  private static final RequestStatus[] VALUES = values();

  public static RequestStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private RequestStatus(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:RequestStatus)
}

