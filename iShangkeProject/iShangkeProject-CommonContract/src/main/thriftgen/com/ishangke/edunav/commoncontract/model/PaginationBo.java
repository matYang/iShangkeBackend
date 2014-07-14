/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ishangke.edunav.commoncontract.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PaginationBo
 */
public class PaginationBo implements org.apache.thrift.TBase<PaginationBo, PaginationBo._Fields>, java.io.Serializable, Cloneable, Comparable<PaginationBo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PaginationBo");

  private static final org.apache.thrift.protocol.TField SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("size", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField OFFSET_FIELD_DESC = new org.apache.thrift.protocol.TField("offset", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField ORDER_BY_ENTITIES_FIELD_DESC = new org.apache.thrift.protocol.TField("orderByEntities", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PaginationBoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PaginationBoTupleSchemeFactory());
  }

  public int size; // required
  public int offset; // required
  public List<OrderByBo> orderByEntities; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SIZE((short)1, "size"),
    OFFSET((short)2, "offset"),
    ORDER_BY_ENTITIES((short)3, "orderByEntities");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SIZE
          return SIZE;
        case 2: // OFFSET
          return OFFSET;
        case 3: // ORDER_BY_ENTITIES
          return ORDER_BY_ENTITIES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SIZE_ISSET_ID = 0;
  private static final int __OFFSET_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SIZE, new org.apache.thrift.meta_data.FieldMetaData("size", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.OFFSET, new org.apache.thrift.meta_data.FieldMetaData("offset", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ORDER_BY_ENTITIES, new org.apache.thrift.meta_data.FieldMetaData("orderByEntities", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, OrderByBo.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PaginationBo.class, metaDataMap);
  }

  public PaginationBo() {
  }

  public PaginationBo(
    int size,
    int offset,
    List<OrderByBo> orderByEntities)
  {
    this();
    this.size = size;
    setSizeIsSet(true);
    this.offset = offset;
    setOffsetIsSet(true);
    this.orderByEntities = orderByEntities;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PaginationBo(PaginationBo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.size = other.size;
    this.offset = other.offset;
    if (other.isSetOrderByEntities()) {
      List<OrderByBo> __this__orderByEntities = new ArrayList<OrderByBo>(other.orderByEntities.size());
      for (OrderByBo other_element : other.orderByEntities) {
        __this__orderByEntities.add(new OrderByBo(other_element));
      }
      this.orderByEntities = __this__orderByEntities;
    }
  }

  public PaginationBo deepCopy() {
    return new PaginationBo(this);
  }

  @Override
  public void clear() {
    setSizeIsSet(false);
    this.size = 0;
    setOffsetIsSet(false);
    this.offset = 0;
    this.orderByEntities = null;
  }

  public int getSize() {
    return this.size;
  }

  public PaginationBo setSize(int size) {
    this.size = size;
    setSizeIsSet(true);
    return this;
  }

  public void unsetSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  /** Returns true if field size is set (has been assigned a value) and false otherwise */
  public boolean isSetSize() {
    return EncodingUtils.testBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  public void setSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SIZE_ISSET_ID, value);
  }

  public int getOffset() {
    return this.offset;
  }

  public PaginationBo setOffset(int offset) {
    this.offset = offset;
    setOffsetIsSet(true);
    return this;
  }

  public void unsetOffset() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OFFSET_ISSET_ID);
  }

  /** Returns true if field offset is set (has been assigned a value) and false otherwise */
  public boolean isSetOffset() {
    return EncodingUtils.testBit(__isset_bitfield, __OFFSET_ISSET_ID);
  }

  public void setOffsetIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OFFSET_ISSET_ID, value);
  }

  public int getOrderByEntitiesSize() {
    return (this.orderByEntities == null) ? 0 : this.orderByEntities.size();
  }

  public java.util.Iterator<OrderByBo> getOrderByEntitiesIterator() {
    return (this.orderByEntities == null) ? null : this.orderByEntities.iterator();
  }

  public void addToOrderByEntities(OrderByBo elem) {
    if (this.orderByEntities == null) {
      this.orderByEntities = new ArrayList<OrderByBo>();
    }
    this.orderByEntities.add(elem);
  }

  public List<OrderByBo> getOrderByEntities() {
    return this.orderByEntities;
  }

  public PaginationBo setOrderByEntities(List<OrderByBo> orderByEntities) {
    this.orderByEntities = orderByEntities;
    return this;
  }

  public void unsetOrderByEntities() {
    this.orderByEntities = null;
  }

  /** Returns true if field orderByEntities is set (has been assigned a value) and false otherwise */
  public boolean isSetOrderByEntities() {
    return this.orderByEntities != null;
  }

  public void setOrderByEntitiesIsSet(boolean value) {
    if (!value) {
      this.orderByEntities = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SIZE:
      if (value == null) {
        unsetSize();
      } else {
        setSize((Integer)value);
      }
      break;

    case OFFSET:
      if (value == null) {
        unsetOffset();
      } else {
        setOffset((Integer)value);
      }
      break;

    case ORDER_BY_ENTITIES:
      if (value == null) {
        unsetOrderByEntities();
      } else {
        setOrderByEntities((List<OrderByBo>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SIZE:
      return Integer.valueOf(getSize());

    case OFFSET:
      return Integer.valueOf(getOffset());

    case ORDER_BY_ENTITIES:
      return getOrderByEntities();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SIZE:
      return isSetSize();
    case OFFSET:
      return isSetOffset();
    case ORDER_BY_ENTITIES:
      return isSetOrderByEntities();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PaginationBo)
      return this.equals((PaginationBo)that);
    return false;
  }

  public boolean equals(PaginationBo that) {
    if (that == null)
      return false;

    boolean this_present_size = true;
    boolean that_present_size = true;
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (this.size != that.size)
        return false;
    }

    boolean this_present_offset = true;
    boolean that_present_offset = true;
    if (this_present_offset || that_present_offset) {
      if (!(this_present_offset && that_present_offset))
        return false;
      if (this.offset != that.offset)
        return false;
    }

    boolean this_present_orderByEntities = true && this.isSetOrderByEntities();
    boolean that_present_orderByEntities = true && that.isSetOrderByEntities();
    if (this_present_orderByEntities || that_present_orderByEntities) {
      if (!(this_present_orderByEntities && that_present_orderByEntities))
        return false;
      if (!this.orderByEntities.equals(that.orderByEntities))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_size = true;
    builder.append(present_size);
    if (present_size)
      builder.append(size);

    boolean present_offset = true;
    builder.append(present_offset);
    if (present_offset)
      builder.append(offset);

    boolean present_orderByEntities = true && (isSetOrderByEntities());
    builder.append(present_orderByEntities);
    if (present_orderByEntities)
      builder.append(orderByEntities);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(PaginationBo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSize()).compareTo(other.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.size, other.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOffset()).compareTo(other.isSetOffset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOffset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.offset, other.offset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOrderByEntities()).compareTo(other.isSetOrderByEntities());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrderByEntities()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.orderByEntities, other.orderByEntities);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("PaginationBo(");
    boolean first = true;

    sb.append("size:");
    sb.append(this.size);
    first = false;
    if (!first) sb.append(", ");
    sb.append("offset:");
    sb.append(this.offset);
    first = false;
    if (!first) sb.append(", ");
    sb.append("orderByEntities:");
    if (this.orderByEntities == null) {
      sb.append("null");
    } else {
      sb.append(this.orderByEntities);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PaginationBoStandardSchemeFactory implements SchemeFactory {
    public PaginationBoStandardScheme getScheme() {
      return new PaginationBoStandardScheme();
    }
  }

  private static class PaginationBoStandardScheme extends StandardScheme<PaginationBo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PaginationBo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.size = iprot.readI32();
              struct.setSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // OFFSET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.offset = iprot.readI32();
              struct.setOffsetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ORDER_BY_ENTITIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.orderByEntities = new ArrayList<OrderByBo>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  OrderByBo _elem2;
                  _elem2 = new OrderByBo();
                  _elem2.read(iprot);
                  struct.orderByEntities.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setOrderByEntitiesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PaginationBo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SIZE_FIELD_DESC);
      oprot.writeI32(struct.size);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(OFFSET_FIELD_DESC);
      oprot.writeI32(struct.offset);
      oprot.writeFieldEnd();
      if (struct.orderByEntities != null) {
        oprot.writeFieldBegin(ORDER_BY_ENTITIES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.orderByEntities.size()));
          for (OrderByBo _iter3 : struct.orderByEntities)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PaginationBoTupleSchemeFactory implements SchemeFactory {
    public PaginationBoTupleScheme getScheme() {
      return new PaginationBoTupleScheme();
    }
  }

  private static class PaginationBoTupleScheme extends TupleScheme<PaginationBo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PaginationBo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSize()) {
        optionals.set(0);
      }
      if (struct.isSetOffset()) {
        optionals.set(1);
      }
      if (struct.isSetOrderByEntities()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSize()) {
        oprot.writeI32(struct.size);
      }
      if (struct.isSetOffset()) {
        oprot.writeI32(struct.offset);
      }
      if (struct.isSetOrderByEntities()) {
        {
          oprot.writeI32(struct.orderByEntities.size());
          for (OrderByBo _iter4 : struct.orderByEntities)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PaginationBo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.size = iprot.readI32();
        struct.setSizeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.offset = iprot.readI32();
        struct.setOffsetIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.orderByEntities = new ArrayList<OrderByBo>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            OrderByBo _elem7;
            _elem7 = new OrderByBo();
            _elem7.read(iprot);
            struct.orderByEntities.add(_elem7);
          }
        }
        struct.setOrderByEntitiesIsSet(true);
      }
    }
  }

}
