public class GeneralFeedbackHandler extends Handler{
    @Override
    public void handleRequest(Message message){
        if (message.getType() == FeedbackType.GENERAL_FEEDBACK){
            System.out.println("General Feedback Handler: Feedback received from " + message.getSender().getName() + " <" + message.getSender().getEmail() + ">");
        } else if (successor != null){
            successor.handleRequest(message);
        }
    }
}
