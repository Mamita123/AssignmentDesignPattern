package org.example.mediator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChatClient extends Parent {

    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;
    @FXML
    private ComboBox<String> recipientComboBox;  // For selecting recipients
    @FXML
    private Button sendButton;

    private final ChatClientController controller; // Reference to the controller instance
    private final Mediator mediator; // Reference to the mediator object

    public ChatClient(String username, Mediator mediator) {
        this.mediator = mediator;
        this.controller = new ChatClientController(this, username, mediator);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        loader.setController(controller);
        try {
            Parent root = loader.load();
            getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMessage(String message, String sender) {
        Platform.runLater(() -> messageArea.appendText(sender + ": " + message + "\n"));
    }

    public ChatClientController getController() {
        return controller;
    }

    public String getUsername() {
        return controller.getUsername();
    }

    // Getter methods for other UI elements (optional)
    public TextArea getMessageArea() {
        return messageArea;
    }

    public TextField getMessageField() {
        return messageField;
    }

    public ComboBox<String> getRecipientComboBox() {
        return recipientComboBox;
    }

    public Button getSendButton() {
        return sendButton;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

