package Serialization.SocketSerialization;

import java.io.*;
import java.net.*;

public class Server {
    public static final int port = 7171;

    public static void main(String[] args) throws Exception{
        new Server();
    }

    public Server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("[SERVER] Waiting client on port " + port + "!");
        Socket socket = serverSocket.accept();

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        Packet recvmsg = (Packet) inputStream.readObject();
        System.out.println(recvmsg.messages);

        if(recvmsg.messages.equals("Hello")){
            Packet packet = new Packet("Hey, from the server");
            outputStream.writeObject(packet);
        }

        serverSocket.close();
    }
}