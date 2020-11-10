package com.iuoip.jdbc;

/**
 * 用户类存放userinfo数据
 */
public class User {

    private int id;  //用户id
    private String username; //用户名
    private String password; //用户密码
    private String realname; //用户真实名
    private double salary;   //用户薪资

//    public User(int id, String username, String password, String realname, double salary) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.realname = realname;
//        this.salary = salary;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
