package com.iuoip.net.chart;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 聊天程序接收端线程
 */
public class ReceiveThread implements Runnable {
    private DatagramSocket datagramSocket;

    public ReceiveThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024 * 1024];
                //定义数据报包接收发送端发送的数据报包数据
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

                //接收  阻塞式方法
                datagramSocket.receive(datagramPacket);

                String ip = datagramPacket.getAddress().getHostAddress(); //获取发送端ip
                if (ip.equals("192.168.8.70")){
                    break;
                }
                String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(ip + ">>>" + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null)
                datagramSocket.close();
        }
    }
}
