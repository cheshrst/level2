package lesson7.server;

import lesson7.server.ChatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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
//        privateMessage();
        listenMessages();
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




//    private void privateMessage() throws IOException{
//        new Thread(() -> {
//            String inboundMessage = null;
//            try {
//                inboundMessage = server.;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (inboundMessage.startsWith("-pm")){
//            String to = inboundMessage.split("\\s")[1];
//            String msg = inboundMessage.split("\\s")[2];
//            server.wisperMsg(this, to, msg);
//        }
//        }).start();




    private void performAuthentication() throws IOException{
        while (true){
            String inboundMessage = in.readUTF();
            if(inboundMessage.startsWith("-auth")){

                String[] credentials = inboundMessage.split("\\s");
//                Optional<String> maybeUsername =
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
                                        sendMessage("Auth done!");
                                    } else {
                                        sendMessage("Current username is already occupied. \nTry later...");
                                    }
                                },
                                () -> sendMessage("Bad credentials.")
                        );

                if(isSuccess.get())break;


//                if(maybeUsername.isPresent()){
//                    String s = maybeUsername.get();
//                }
            }
        }
    }









//    public void wisperMsg(ClientHandler from, String to, String msg)
//    {
//
//        for (ClientHandler user: users) {
//            if(user.getLogin().equals(to)) {
//                user.sendMsg("[W from: " + from.getName() + "] " + msg);
//                break;
//            }
//        }
//        from.sendMessage("[W to: " + to + "] " + msg);
//    }

    public void sendMessage(String outboundMessage){
        try {
            out.writeUTF(outboundMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void readMessage(){
                try {

                    server.broadcastMessage(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listenMessages(){
        while (true){

            readMessage();
        }
    }
}