// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: single_level.proto at 24:1
package com.squareup.wire.protos.single_level;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

public final class Foos extends Message<Foos, Foos.Builder> {
  public static final ProtoAdapter<Foos> ADAPTER = new ProtoAdapter<Foos>(FieldEncoding.LENGTH_DELIMITED, Foos.class) {
    @Override
    public int encodedSize(Foos value) {
      return Foo.ADAPTER.asRepeated().encodedSizeWithTag(1, value.foos)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Foos value) throws IOException {
      if (value.foos != null) Foo.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.foos);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Foos decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.foos.add(Foo.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public Foos redact(Foos value) {
      Builder builder = value.newBuilder();
      redactElements(builder.foos, Foo.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.protos.single_level.Foo#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Foo> foos;

  public Foos(List<Foo> foos) {
    this(foos, ByteString.EMPTY);
  }

  public Foos(List<Foo> foos, ByteString unknownFields) {
    super(unknownFields);
    this.foos = immutableCopyOf("foos", foos);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.foos = copyOf("foos", foos);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Foos)) return false;
    Foos o = (Foos) other;
    return equals(unknownFields(), o.unknownFields())
        && equals(foos, o.foos);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (foos != null ? foos.hashCode() : 1);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (foos != null) builder.append(", foos=").append(foos);
    return builder.replace(0, 2, "Foos{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Foos, Builder> {
    public List<Foo> foos;

    public Builder() {
      foos = newMutableList();
    }

    public Builder foos(List<Foo> foos) {
      checkElementsNotNull(foos);
      this.foos = foos;
      return this;
    }

    @Override
    public Foos build() {
      return new Foos(foos, buildUnknownFields());
    }
  }
}