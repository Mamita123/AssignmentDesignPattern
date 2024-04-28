public class Message {
    private FeedbackType type;
    private String content;

    private Sender sender;

    public Message(FeedbackType type, String content, Sender sender){
        this.type = type;
        this.content = content;
        this.sender = sender;
    }

    public FeedbackType getType(){
        return type;
    }

    public String getContent(){
        return content;
    }

    public Sender getSender(){
        return sender;
    }
}
