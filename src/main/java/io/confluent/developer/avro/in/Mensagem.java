/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.confluent.developer.avro.in;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Mensagem extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5687564740275662846L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Mensagem\",\"namespace\":\"io.confluent.developer.avro.in\",\"fields\":[{\"name\":\"numCtrlIF\",\"type\":\"string\",\"avro.java.string\":\"String\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Mensagem> ENCODER =
      new BinaryMessageEncoder<Mensagem>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Mensagem> DECODER =
      new BinaryMessageDecoder<Mensagem>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Mensagem> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Mensagem> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Mensagem>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Mensagem to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Mensagem from a ByteBuffer. */
  public static Mensagem fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence numCtrlIF;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Mensagem() {}

  /**
   * All-args constructor.
   * @param numCtrlIF The new value for numCtrlIF
   */
  public Mensagem(java.lang.CharSequence numCtrlIF) {
    this.numCtrlIF = numCtrlIF;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return numCtrlIF;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: numCtrlIF = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'numCtrlIF' field.
   * @return The value of the 'numCtrlIF' field.
   */
  public java.lang.CharSequence getNumCtrlIF() {
    return numCtrlIF;
  }

  /**
   * Sets the value of the 'numCtrlIF' field.
   * @param value the value to set.
   */
  public void setNumCtrlIF(java.lang.CharSequence value) {
    this.numCtrlIF = value;
  }

  /**
   * Creates a new Mensagem RecordBuilder.
   * @return A new Mensagem RecordBuilder
   */
  public static io.confluent.developer.avro.in.Mensagem.Builder newBuilder() {
    return new io.confluent.developer.avro.in.Mensagem.Builder();
  }

  /**
   * Creates a new Mensagem RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Mensagem RecordBuilder
   */
  public static io.confluent.developer.avro.in.Mensagem.Builder newBuilder(io.confluent.developer.avro.in.Mensagem.Builder other) {
    return new io.confluent.developer.avro.in.Mensagem.Builder(other);
  }

  /**
   * Creates a new Mensagem RecordBuilder by copying an existing Mensagem instance.
   * @param other The existing instance to copy.
   * @return A new Mensagem RecordBuilder
   */
  public static io.confluent.developer.avro.in.Mensagem.Builder newBuilder(io.confluent.developer.avro.in.Mensagem other) {
    return new io.confluent.developer.avro.in.Mensagem.Builder(other);
  }

  /**
   * RecordBuilder for Mensagem instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Mensagem>
    implements org.apache.avro.data.RecordBuilder<Mensagem> {

    private java.lang.CharSequence numCtrlIF;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.confluent.developer.avro.in.Mensagem.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.numCtrlIF)) {
        this.numCtrlIF = data().deepCopy(fields()[0].schema(), other.numCtrlIF);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Mensagem instance
     * @param other The existing instance to copy.
     */
    private Builder(io.confluent.developer.avro.in.Mensagem other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.numCtrlIF)) {
        this.numCtrlIF = data().deepCopy(fields()[0].schema(), other.numCtrlIF);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'numCtrlIF' field.
      * @return The value.
      */
    public java.lang.CharSequence getNumCtrlIF() {
      return numCtrlIF;
    }

    /**
      * Sets the value of the 'numCtrlIF' field.
      * @param value The value of 'numCtrlIF'.
      * @return This builder.
      */
    public io.confluent.developer.avro.in.Mensagem.Builder setNumCtrlIF(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.numCtrlIF = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'numCtrlIF' field has been set.
      * @return True if the 'numCtrlIF' field has been set, false otherwise.
      */
    public boolean hasNumCtrlIF() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'numCtrlIF' field.
      * @return This builder.
      */
    public io.confluent.developer.avro.in.Mensagem.Builder clearNumCtrlIF() {
      numCtrlIF = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Mensagem build() {
      try {
        Mensagem record = new Mensagem();
        record.numCtrlIF = fieldSetFlags()[0] ? this.numCtrlIF : (java.lang.CharSequence) defaultValue(fields()[0]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Mensagem>
    WRITER$ = (org.apache.avro.io.DatumWriter<Mensagem>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Mensagem>
    READER$ = (org.apache.avro.io.DatumReader<Mensagem>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
