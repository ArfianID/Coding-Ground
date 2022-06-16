package Serialization.SocketSerialization;

import java.io.Serializable;

public class Packet implements Serializable{
    String messages;

    public Packet(String msg){
        this.messages = msg;
    }
}
