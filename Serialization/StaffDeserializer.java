package Serialization;

import java.io.*;

public class StaffDeserializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objInput = new ObjectInputStream(new FileInputStream("src/main/java/com/serialization/serialized/Staff.ser"));
        Staff staff = (Staff) objInput.readObject();
        System.out.println("Name: " + staff.name +
                           "\nNick Name:  " + staff.nickName +
                           "\nTitle: " + staff.title +
                           "\nAge: " + staff.age);
        objInput.close();
    }
}