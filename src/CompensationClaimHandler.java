public class CompensationClaimHandler extends Handler{
    @Override
    public void handleRequest(Message message){
        if (message.getType() == FeedbackType.COMPENSATION_CLAIM){
            System.out.println("Compensation claim handler: Claim received from " + message.getSender().getName() + " <" + message.getSender().getEmail() + " >");
             ;
        } else if (successor != null){
            successor.handleRequest(message);
        }
    }
}
