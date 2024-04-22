package org.example.mediator;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class ChatClientController {

    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;
    @FXML
    private ComboBox<String> recipientComboBox;
    @FXML
    private Button sendButton;

    private final ChatClient chatClient;
    private final Mediator mediator;
    private final String username;

    public ChatClientController(ChatClient chatClient, String username, Mediator mediator) {
        this.chatClient = chatClient;
        this.username = username;
        this.mediator = mediator;
    }

    @FXML
    public void initialize() {
        // Initialize recipientComboBox (assuming you have a method to get recipients)
        recipientComboBox.getItems().addAll(getListOfRecipients());
    }


    @FXML
    public void handleSendMessage() {
        String message = messageField.getText();
        String recipient = recipientComboBox.getSelectionModel().getSelectedItem();

        if (message.isEmpty()) {
            // Show error message
            messageArea.appendText("Error: Message cannot be empty.\n");
            return;
        }

        if (recipient != null) {
            mediator.sendMessage(message, username, recipient);
        } else {
            // Display error message if no recipient is selected
            messageArea.appendText("Error: Please select a recipient.\n");
        }
        messageField.clear();
    }

    public void receiveMessage(String message, String sender) {
        messageArea.appendText(sender + ": " + message + "\n");
    }

    public String getUsername() {
        return username;
    }

    // Replace this with your logic to retrieve a list of recipient usernames
    private List<String> getListOfRecipients() {
        // Example: Get recipients from database or service
        List<String> recipients = new ArrayList<>();
        recipients.add("User1");
        recipients.add("User2");
        recipients.add("User3");
        return recipients;
    }
}

