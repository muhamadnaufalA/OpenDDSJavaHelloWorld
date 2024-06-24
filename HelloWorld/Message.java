package HelloWorld;
public final class Message implements java.io.Serializable {
  public int id;
  public String text;

  public Message() {}

  public Message(int _id, String _text) {
    id = _id;
    text = _text;
  }
}
