package com.iuoip.net.chart;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 聊天程序
 */
public class ChartDemo {
    public static void main(String[] args) {
        try {
            //发送端默认启动端口，也可以手动设置端口
            DatagramSocket sendSocket = new DatagramSocket();
            //接收端需要监听一个端口
            DatagramSocket receiveSocket = new DatagramSocket(1234);

            new Thread(new SendThread(sendSocket)).start();
            new Thread(new ReceiveThread(receiveSocket)).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
