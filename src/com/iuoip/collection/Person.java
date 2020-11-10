package com.iuoip.collection;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String role;
    private String sex;

    public Person(int id, String name, String role, String sex) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.sex = sex;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(role, person.role) &&
                Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, sex);
    }
}
