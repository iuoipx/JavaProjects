package com.iuoip.serializable;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) {
        Person person = new Person("asd",231);
        try {
            //序列化
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.txt"));
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("out.txt"));
            Person person1 = (Person) objectInputStream.readObject();
            System.out.println(person1.toString());
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
