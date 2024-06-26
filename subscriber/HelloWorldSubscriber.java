package subscriber;
import DDS.*;
import HelloWorld.*;
import OpenDDS.DCPS.*;
import idl2jni.corba.org.omg.CORBA.StringSeqHolder;

public class HelloWorldSubscriber {

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

        // Create subscriber
        Subscriber sub = dp.create_subscriber(SUBSCRIBER_QOS_DEFAULT.get(), null, DEFAULT_STATUS_MASK.value);

        // Create data reader
        DataReaderListenerImpl listener = new DataReaderListenerImpl();
        DataReader dr = sub.create_datareader(top, DATAREADER_QOS_DEFAULT.get(), listener, DEFAULT_STATUS_MASK.value);

        // Keep the subscriber running
        try {
            Thread.sleep(10000);  // Adjust as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clean up
        dp.delete_contained_entities();
        dpf.delete_participant(dp);
        TheServiceParticipant.shutdown();
    }
}

class DataReaderListenerImpl extends DDS._DataReaderListenerLocalBase {

    @Override
    public synchronized void on_data_available(DataReader reader) {
        MessageDataReader mdr = MessageDataReaderHelper.narrow(reader);
        if (mdr == null) {
            System.err.println("read: narrow failed.");
            return;
        }

        MessageHolder mh = new MessageHolder(new Message());
        SampleInfoHolder sih = new SampleInfoHolder(new SampleInfo(0, 0, 0, new Time_t(), 0, 0, 0, 0, 0, 0, 0, false,0));
        int status = mdr.take_next_sample(mh, sih);

        if (status == RETCODE_OK.value) {
            System.out.println("Received message: " + mh.value.text);
        } else if (status == RETCODE_NO_DATA.value) {
            System.err.println("ERROR: reader received DDS::RETCODE_NO_DATA!");
        } else {
            System.err.println("ERROR: read Message: Error: " + status);
        }
    }

    @Override
    public void on_requested_deadline_missed(DDS.DataReader reader, DDS.RequestedDeadlineMissedStatus status) {
        System.err.println("DataReaderListenerImpl.on_requested_deadline_missed");
    }

    @Override
    public void on_requested_incompatible_qos(DDS.DataReader reader, DDS.RequestedIncompatibleQosStatus status) {
        System.err.println("DataReaderListenerImpl.on_requested_incompatible_qos");
    }

    @Override
    public void on_sample_rejected(DDS.DataReader reader, DDS.SampleRejectedStatus status) {
        System.err.println("DataReaderListenerImpl.on_sample_rejected");
    }

    @Override
    public void on_liveliness_changed(DDS.DataReader reader, DDS.LivelinessChangedStatus status) {
        System.err.println("DataReaderListenerImpl.on_liveliness_changed");
    }

    @Override
    public void on_subscription_matched(DDS.DataReader reader, DDS.SubscriptionMatchedStatus status) {
        System.err.println("DataReaderListenerImpl.on_subscription_matched");
    }

    @Override
    public void on_sample_lost(DDS.DataReader reader, DDS.SampleLostStatus status) {
        System.err.println("DataReaderListenerImpl.on_sample_lost");
    }
}
