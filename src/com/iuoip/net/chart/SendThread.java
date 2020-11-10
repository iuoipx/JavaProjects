package com.iuoip.net.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 聊天程序发送端线程
 */
public class SendThread implements Runnable {
    private DatagramSocket datagramSocket;

    public SendThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
            String line = null;
            while (((line = buf.readLine()) != null)) {
                if ("886".equalsIgnoreCase(line)) {
                    break;
                }

                DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(),
                        line.length(), InetAddress.getByName("192.168.8.255"), 9991);

                datagramSocket.send(datagramPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null)
                datagramSocket.close();
        }
    }
}
