package Serialization;

import java.io.Serializable;

public class Staff implements Serializable{
    String name;
    transient String nickName;
    String title;
    int age;

    public Staff(String name, String nickName, String title, int age) {
        this.name = name;
        this.nickName = nickName;
        this.title = title;
        this.age = age;
    }
}

