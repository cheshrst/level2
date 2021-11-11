package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ServerSocket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Server() {
        try {
            socket = new ServerSocket(8080);
            this.scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        System.out.println("Server socket started...");
        System.out.println("Server socket is waiting for a connection...");
        Socket accepted = socket.accept();
        System.out.println("Client connected...");
        System.out.println("Address: " + accepted.getInetAddress());

        in = new DataInputStream(accepted.getInputStream());
        out = new DataOutputStream(accepted.getOutputStream());

        readInboundMessage();
        sendOutboundMessage();


    }



    private void sendOutboundMessage() {

        while (true) {
            try {

                String outboundMessage = scanner.nextLine();
                out.writeUTF("msg: " + outboundMessage);
            } catch (IOException ex) {
                System.out.println("Connection closed.");
                break;
            }
        }

    }

    private void readInboundMessage() {
        new Thread(() -> {
            while (true) {
        try {
            String inboundMessage = in.readUTF();
            System.out.println("msg: " + inboundMessage);
        } catch (EOFException ex) {
            throw new MyServerException("End of stream reached unexpectedly. Probably, client is shutdown.", ex);
        } catch (IOException ex) {
            throw new MyServerException("Something went wrong during inbound message read-operation.", ex);
        }
    }
    })
            .start();

    }
}
