package Networking.SingleInteraction;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7771);

        System.out.println("[Server] Waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("[Server] Client connected!");
        
        PrintWriter sends = new PrintWriter(socket.getOutputStream(), true);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        sends.println(input);

        scan.close();
        serverSocket.close();
        System.out.println("[Server] Server closed!");
    }

}
