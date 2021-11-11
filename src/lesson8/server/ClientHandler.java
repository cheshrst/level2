package lesson8.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientHandler {
    private String name;
    private final Socket socket;
    private final ChatServer server;
    private final DataInputStream in;
    private final DataOutputStream out;


    public ClientHandler(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            throw new RuntimeException("Smth went wrong ", ex);
        }
        doAuthication();
        commands();
    }



    public String getName() {
        return name;
    }
    private void doAuthication(){
        try {
            performAuthentication();
        }catch (IOException ex){
            throw new RuntimeException("Smth went wrong during a client authetication", ex);
        }
    }
    private void commands(){
        try {
            commandsWithMsg();
        }catch (IOException ex){
            server.broadcastMessage("[" + this.getName() + "] leave from server.");
            server.removeUsername(this);
            throw new RuntimeException("Smth went wrong with commands", ex);
        }
    }


        private void commandsWithMsg() throws IOException {

        while (true) {
                String inboundMessage = in.readUTF();
                if (inboundMessage.startsWith("-pm")) {
                    String[] credentials = inboundMessage.split("\\s");
                    String[] message = inboundMessage.split(credentials[1]);
                    String msg = message[1];
                    String client = credentials[1];
                    if(!server.isUsernameOccupied(client)){
                        sendMessage("Client not found");
                    }else{
                    server.wisperMsg(this.getName(), client, msg);}
                    sendMessage("[Msg to: " + client + "] " + msg);
                }else if(inboundMessage.startsWith("-exit")){
                    sendMessage("Logged out!");
                    server.removeUsername(this);
                } else {
                    server.broadcastMessage(this.getName() + ": " + inboundMessage);
                }
            }
        }






    private void performAuthentication() throws IOException{
        sendMessage("Welcome! \nWrite -auth to start chatting!");
        while (true){
            this.socket.setSoTimeout(5000);
            String inboundMessage = in.readUTF();
            if(inboundMessage.startsWith("-auth")){
                String[] credentials = inboundMessage.split("\\s");
                AtomicBoolean isSuccess = new AtomicBoolean(false);
                server.getAuthenticationService()
                        .findNickByLoginAndPassword(credentials[1], credentials[2])
                        .ifPresentOrElse(
                                username -> {
                                    if (!server.isUsernameOccupied(username)) {
                                        server.broadcastMessage(String.format("User[%s] is logged in", username));
                                        name = username;
                                        server.addClient(this);
                                        isSuccess.set(true);
                                        sendMessage("Auth done! Enjoy :)");
                                        try {
                                            this.socket.setSoTimeout(0);
                                        } catch (SocketException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        sendMessage("Current username is already occupied. \nTry later...");
                                    }
                                },
                                () -> sendMessage("Bad credentials.")
                        );

                if(isSuccess.get())break;
            }else{
                sendMessage("You need to be logged.");
            }
        }
    }


    public void sendMessage(String outboundMessage){
        try {
            out.writeUTF(outboundMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}