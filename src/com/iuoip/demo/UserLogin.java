package com.iuoip.demo;

import java.util.Scanner;

public class UserLogin {
    private static final int COUNT = 3;
    public static void main(String[] args) {
        User user1 = new User("abcd","123456");
        String userName = null;
        String password = null;
        User user2 = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input your username and password: ");

        for (int i = 0; i < COUNT; i++) {
            userName = scanner.next();
            password = scanner.next();
            user2.setUserName(userName);
            user2.setPassword(password);
            if (user1.equals(user2)){
                System.out.println("login success !!!");
                break;
            }
            else if(i == COUNT-1)
                System.out.println("no chance! system exit");
            else
                System.out.println("username or password error,please input again: ");
        }
    }
}
