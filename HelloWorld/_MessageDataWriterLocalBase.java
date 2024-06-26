package HelloWorld;
public abstract class _MessageDataWriterLocalBase extends idl2jni.corba.org.omg.CORBA.LocalObject implements MessageDataWriter {
  private String[] _type_ids = {"IDL:Messenger/MessageDataWriter:1.0", "IDL:DDS/DataWriter:1.0", "IDL:DDS/Entity:1.0"};

  public String[] _ids() { return (String[])_type_ids.clone(); }
}
