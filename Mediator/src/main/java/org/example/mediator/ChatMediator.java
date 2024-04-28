package org.example.mediator;



import java.util.ArrayList;
import java.util.List;

public class ChatMediator extends Mediator {

    private final List<ChatClientController> clients;

    public ChatMediator() {
        clients = new ArrayList<>();
    }

    @Override
    public void registerClient(ChatClientController client) {
        clients.add(client);
    }

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        for (ChatClientController client : clients) {
            if (client.getUsername().equals(recipient) || recipient.equals("All")) {
                client.receiveMessage(message, sender);
            }
        }
    }
}