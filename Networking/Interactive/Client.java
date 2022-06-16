package Networking.Interactive;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, NullPointerException {
        Socket socket = new Socket("localhost", 7771);
        System.out.println("You are connected to the server!");

        PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader listen = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scan = new Scanner(System.in);
        
        try {
            while (true) {
                String output = listen.readLine();
                System.out.println("Server: " + output);
                String input = scan.nextLine();
                if (input.equals("quit")) {
                    write.println("Client has disconnected");
                    break;
                }
                write.println(input);
            }
        } catch (NullPointerException e) {
            System.err.println("Server has disconnected [Null Pointer Exception]");
        } finally {
            scan.close();
            write.close();
            listen.close();
            socket.close();
        }
    }
}
