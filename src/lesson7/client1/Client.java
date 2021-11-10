package lesson7.client1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Client() {
        try {
            this.socket = new Socket("127.0.0.1", 8888);
            this.scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    try {
                        String inboundMessage = in.readUTF();
                        System.out.println(inboundMessage);
                    } catch (IOException ex) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            })
                    .start();

        System.out.println("Chat started \n" +
                "Write any message:");
        while (true) {
            try {

                String outboundMessage = scanner.nextLine();
                out.writeUTF(outboundMessage);
            } catch (IOException ex) {
                System.out.println("Connection closed.");
                break;
            }
        }

    }
}
