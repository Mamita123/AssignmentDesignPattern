public class ContactRequestHandler extends Handler{
    @Override
    public void handleRequest(Message message){
        if (message.getType() == FeedbackType.CONTACT_REQUEST){
            System.out.println("Contact Request Handler: Request received from" + message.getSender().getName() + " <" + message.getSender().getEmail() + " >");
        } else if (successor != null){
            successor.handleRequest(message);
        }
    }
}
