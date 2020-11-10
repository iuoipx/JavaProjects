package com.iuoip.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 从键盘输入数据
 */
public class UdpSend02 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            //1.创建udp socket服务
            datagramSocket = new DatagramSocket();

            //2.将数据封装到数据包中
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in,"GBK"));
            String line = null;
            while ((line = buf.readLine()) != null) {
                if ("bye".equalsIgnoreCase(line)) {
                    break;
                } else {
                    DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(),
                            line.length(), InetAddress.getByName("localhost"),9888);

                    //3.发送数据
                    datagramSocket.send(datagramPacket);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(datagramSocket != null)
                datagramSocket.close();
        }
    }
}
