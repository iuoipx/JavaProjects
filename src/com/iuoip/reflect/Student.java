package com.iuoip.reflect;

import com.iuoip.serializable.Person;

public class Student extends Person {
    private String studentID;

    public Student() {
    }

    public Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
    }

    public void study() {
        System.out.println();
    }

    public void listen(){

    }
}
