package HelloWorld;
public interface MessageDataWriterOperations extends DDS.DataWriterOperations {
  int register_instance(HelloWorld.Message instance);
  int register_instance_w_timestamp(HelloWorld.Message instance, DDS.Time_t timestamp);
  int unregister_instance(HelloWorld.Message instance, int handle);
  int unregister_instance_w_timestamp(HelloWorld.Message instance, int handle, DDS.Time_t timestamp);
  int write(HelloWorld.Message instance_data, int handle);
  int write_w_timestamp(HelloWorld.Message instance_data, int handle, DDS.Time_t source_timestamp);
  int dispose(HelloWorld.Message instance_data, int instance_handle);
  int dispose_w_timestamp(HelloWorld.Message instance_data, int instance_handle, DDS.Time_t source_timestamp);
  int get_key_value(HelloWorld.MessageHolder key_holder, int handle);
  int lookup_instance(HelloWorld.Message instance_data);
}
