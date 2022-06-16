package Networking.SingleInteraction;

import java.io.*;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 7771);
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String output = bf.readLine();
        JOptionPane.showMessageDialog(null, output, "Server", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
        s.close();
    }
}
