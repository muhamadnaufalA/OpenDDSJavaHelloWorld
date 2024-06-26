package HelloWorld;
public interface MessageTypeSupportOperations extends OpenDDS.DCPS.TypeSupportOperations {
  int encode_to_string(HelloWorld.Message sample, idl2jni.corba.org.omg.CORBA.StringHolder encoded, OpenDDS.DCPS.RepresentationFormat format);
  int encode_to_bytes(HelloWorld.Message sample, DDS.OctetSeqHolder encoded, OpenDDS.DCPS.RepresentationFormat format);
  int decode_from_string(String encoded, HelloWorld.MessageHolder sample, OpenDDS.DCPS.RepresentationFormat format);
  int decode_from_bytes(byte[] encoded, HelloWorld.MessageHolder sample, OpenDDS.DCPS.RepresentationFormat format);
}
