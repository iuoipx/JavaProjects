package com.iuoip.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.8.121");
            System.out.println(InetAddress.getLocalHost().toString()); // PC-71/192.168.8.71
            System.out.println(inetAddress.toString()); // localhost/127.0.0.1  /192.168.8.121
            System.out.println(inetAddress.getHostAddress()); // 127.0.0.1  192.168.8.121
            System.out.println(inetAddress.getHostName()); // localhost  chendikai  获取计算机名 如果计算机名没有在网络上注册，则获取到ip
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
