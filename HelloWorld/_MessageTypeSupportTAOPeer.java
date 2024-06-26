package HelloWorld;
public class _MessageTypeSupportTAOPeer extends idl2jni.runtime.i2jrt.TAOLocalObject implements MessageTypeSupport {
  protected _MessageTypeSupportTAOPeer(long ptr) {
    super(ptr);
  }

  public native int encode_to_string(HelloWorld.Message sample, idl2jni.corba.org.omg.CORBA.StringHolder encoded, OpenDDS.DCPS.RepresentationFormat format);

  public native int encode_to_bytes(HelloWorld.Message sample, DDS.OctetSeqHolder encoded, OpenDDS.DCPS.RepresentationFormat format);

  public native int decode_from_string(String encoded, HelloWorld.MessageHolder sample, OpenDDS.DCPS.RepresentationFormat format);

  public native int decode_from_bytes(byte[] encoded, HelloWorld.MessageHolder sample, OpenDDS.DCPS.RepresentationFormat format);

  public native DDS.DataWriter create_datawriter();

  public native DDS.DataReader create_datareader();

  public native DDS.DataReader create_multitopic_datareader();

  public native boolean has_dcps_key();

  public native int unregister_type(DDS.DomainParticipant domain, String type_name);

  public native void representations_allowed_by_type(DDS.DataRepresentationIdSeqHolder seq);

  public native OpenDDS.DCPS.RepresentationFormat make_format(short representation);

  public native int register_type(DDS.DomainParticipant domain, String type_name);

  public native String get_type_name();


  static {
    String propVal = System.getProperty("opendds.native.debug");
    if (propVal != null && ("1".equalsIgnoreCase(propVal) ||
        "y".equalsIgnoreCase(propVal) ||
        "yes".equalsIgnoreCase(propVal) ||
        "t".equalsIgnoreCase(propVal) ||
        "true".equalsIgnoreCase(propVal)))
      System.loadLibrary("messenger_idl_testd");
    else System.loadLibrary("messenger_idl_test");
  }

}
