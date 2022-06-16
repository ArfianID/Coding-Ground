package Serialization.SocketSerialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        new Client();
    }

    public Client() throws Exception {
        Socket socket = new Socket("127.0.0.1", Server.port);

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

        Packet write = new Packet("Hello");
        outStream.writeObject(write);

        Packet read = (Packet) inStream.readObject();
        System.out.println(read.messages);

        outStream.close();
        socket.close();
    }
}
