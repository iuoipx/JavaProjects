package com.iuoip.net.udp;

import java.io.IOException;
import java.net.*;

public class UdpSend {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            //端口范围 0-65536，0-1024这些端口有特殊用途，不建议使用这些端口
            datagramSocket = new DatagramSocket(8888);

            byte[] bytes = "gxsb".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9888);

            datagramSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null)
                datagramSocket.close();
        }
    }
}
