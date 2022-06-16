package Networking.Interactive;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, NullPointerException {
        ServerSocket serverSocket = new ServerSocket(7771);

        System.out.println("[SERVER] Waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("[SERVER] Client connected!");

        PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader listen = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        Scanner scan = new Scanner(System.in);
        
        try {
            while (true) {
                String input = scan.nextLine();
                if (input.equals("stop")) {
                    write.println("Server has disconnected");
                    break;
                }
                write.println(input);
                String output = listen.readLine();
                System.out.println("Client: " + output);
            }
        } catch (NullPointerException e) {
            System.err.println("Client has disconnected [Null Pointer Exception]");
        } finally {
            scan.close();
            write.close();
            listen.close();
            socket.close();
            serverSocket.close();
        }
    }

}
