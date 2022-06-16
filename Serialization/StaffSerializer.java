package Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StaffSerializer {
    public static void main(String[] args) {
        Staff staff = new Staff("Arfian", "Arfxman", "CTO", 17);

        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("src/main/java/com/serialization/serialized/Staff.ser"));
            obj.writeObject(staff);
            obj.flush();
            obj.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Serialize Successfully!");
        }
    }
}
