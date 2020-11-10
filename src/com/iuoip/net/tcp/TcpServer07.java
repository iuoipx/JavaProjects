package com.iuoip.net.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程服务器端
 */
public class TcpServer07 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，并监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true){
                //2.获取socket连接
                Socket accept = serverSocket.accept();
                new Thread(new TcpServer07Thread(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
