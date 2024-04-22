package org.example.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private final List<ChatClientController> clients; // Use final for immutability

    public Mediator() {
        clients = new ArrayList<>();
    }

    public void registerClient(ChatClientController client) {
        clients.add(client);
    }

    public void sendMessage(String message, String sender, String recipient) {
        for (ChatClientController client : clients) {
            if (client.getUsername().equals(recipient) || recipient.equals("All")) {
                client.receiveMessage(message, sender);
            }
        }
    }
}