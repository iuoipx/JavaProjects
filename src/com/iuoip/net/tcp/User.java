package com.iuoip.net.tcp;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -6466929673181906187L;

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
