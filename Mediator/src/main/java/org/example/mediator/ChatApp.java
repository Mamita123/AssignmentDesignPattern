package org.example.mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a Mediator instance
        Mediator mediator = new ChatMediator();

        // Create multiple ChatClient instances (consider using a list or collection)
        int numClients = 3;
        ChatClient[] clients = new ChatClient[numClients];
        for (int i = 0; i < numClients; i++) {
            clients[i] = new ChatClient("User" + (i + 1), mediator);
        }

        // Register ChatClient controllers with the Mediator
        for (ChatClient client : clients) {
            mediator.registerClient(client.getController());
        }

        // Launch chat windows for each client in a loop
        for (ChatClient client : clients) {
            Stage stage = new Stage();
            stage.setScene(new Scene(client, 400, 300));
            stage.setTitle(client.getUsername() + "'s Chat Window");
            stage.show();

        }}}
