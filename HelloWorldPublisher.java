
import dds.DDS.*;
import HelloWorld.*;
import dds.OpenDDS.DCPS.*;
import tao.CORBA.StringSeqHolder;

public class HelloWorldPublisher {

    public static void main(String[] args) {

        // Initialize participant factory
        DomainParticipantFactory dpf = TheParticipantFactory.WithArgs(new StringSeqHolder(args));
        if (dpf == null) {
            System.err.println("Domain Participant Factory not found");
            return;
        }

        // Create participant
        final int DOMAIN_ID = 42;
        DomainParticipant dp = dpf.create_participant(DOMAIN_ID, PARTICIPANT_QOS_DEFAULT.get(), null, DEFAULT_STATUS_MASK.value);
        if (dp == null) {
            System.err.println("Domain Participant creation failed");
            return;
        }

        // Register type and create topic
        MessageTypeSupportImpl servant = new MessageTypeSupportImpl();
        if (servant.register_type(dp, "") != RETCODE_OK.value) {
            System.err.println("register_type failed");
            return;
        }
        Topic top = dp.create_topic("HelloWorld", servant.get_type_name(), TOPIC_QOS_DEFAULT.get(), null, DEFAULT_STATUS_MASK.value);

        // Create publisher
        Publisher pub = dp.create_publisher(PUBLISHER_QOS_DEFAULT.get(), null, DEFAULT_STATUS_MASK.value);

        // Create data writer
        DataWriter dw = pub.create_datawriter(top, DATAWRITER_QOS_DEFAULT.get(), null, DEFAULT_STATUS_MASK.value);

        // Narrow data writer to type-specific data writer
        MessageDataWriter mdw = MessageDataWriterHelper.narrow(dw);

        // Create message
        Message msg = new Message();
        msg.id = 1;
        msg.text = "Hello World";

        // Register instance and write message
        int handle = mdw.register(msg);
        mdw.write(msg, handle);

        // Clean up
        dp.delete_contained_entities();
        dpf.delete_participant(dp);
        TheServiceParticipant.shutdown();
    }
}
