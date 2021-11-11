package lesson8.adapter;

import lesson7.server.ChatServer;
import lesson8.gui.ChatFrame;

import java.util.function.Consumer;

public class ChatAdapter {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8888;

    private final ChatFrame frame;
    private final ChatConnector connector;

    public ChatAdapter() {
        this.connector = new ChatConnector(HOST,PORT);
        this.frame = new ChatFrame(connector::sendMessage);

        while (true){
            frame.OnReceive().accept(connector.receveMessage());
        }
    }
}
