public class DevelopmentSuggestionHandler extends Handler{
    @Override
    public void handleRequest(Message message) {
        if (message.getType() == FeedbackType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Development Suggestion Handler: Suggestion received from " + message.getSender().getName() + " <" + message.getSender().getEmail() + ">");
            // Handle development suggestion logic
        } else if (successor != null) {
            successor.handleRequest(message);
        }
    }
}
