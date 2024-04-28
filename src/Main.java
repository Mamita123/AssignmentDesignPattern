<<<<<<< HEAD

public class Main {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play(2);

    }
}
=======
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        // Creating handler instances
        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        // Setting up the chain of responsibility
        compensationHandler.setSuccessor(contactHandler);
        contactHandler.setSuccessor(suggestionHandler);
        suggestionHandler.setSuccessor(feedbackHandler);

        // Generating various types of customer feedback with sender names and emails
        Sender sender1 = new Sender("Mamita", "mamita@example.com");
        Sender sender2 = new Sender("Kiran", "kiran@example.com");
        Sender sender3 = new Sender("Bina", "bina@example.com");
        Sender sender4 = new Sender("Sunil", "sunil@example.com");

        Message feedback1 = new Message(FeedbackType.COMPENSATION_CLAIM, "Claim content", sender1);
        Message feedback2 = new Message(FeedbackType.CONTACT_REQUEST, "Contact request content", sender2);
        Message feedback3 = new Message(FeedbackType.DEVELOPMENT_SUGGESTION, "Suggestion content", sender3);
        Message feedback4 = new Message(FeedbackType.GENERAL_FEEDBACK, "General feedback content", sender4);

        // Sending feedback to the handler chain
        EnumSet.allOf(FeedbackType.class).forEach(type -> {
            switch (type) {
                case COMPENSATION_CLAIM:
                    compensationHandler.handleRequest(feedback1);
                    break;
                case CONTACT_REQUEST:
                    contactHandler.handleRequest(feedback2);
                    break;
                case DEVELOPMENT_SUGGESTION:
                    suggestionHandler.handleRequest(feedback3);
                    break;
                case GENERAL_FEEDBACK:
                    feedbackHandler.handleRequest(feedback4);
                    break;
                default:
                    System.out.println("Unsupported feedback type");
            }
        });
    }

}
>>>>>>> origin/main
