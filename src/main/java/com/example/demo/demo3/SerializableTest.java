package com.example.demo.demo3;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student student1 = new Student("lihao", "wjwlh", "21");
        oos.writeObject(student1);
        oos.flush();
        oos.close();
        //反序列化
        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student2 = (Student) ois.readObject();
        System.out.println(student2.getUserName()+ " " +
                student2.getPassword() + " " + student2.getYear());
    }

}
