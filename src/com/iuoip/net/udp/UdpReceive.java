package com.iuoip.net.udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceive {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(9888);

            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

                datagramSocket.receive(datagramPacket); //阻塞方法

                System.out.println(datagramPacket.getAddress().getHostAddress());
                System.out.println(datagramPacket.getAddress().getHostName());
                System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null)
                datagramSocket.close();
        }
    }
}
