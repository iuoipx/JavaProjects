package com.iuoip.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送一次数据，服务端接收一次数据
 */
public class TcpServer01 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，并监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            //2.获取连接
            Socket accept = serverSocket.accept();

            //3.获取socket输入流，接收客户端发送的数据
            InputStream inputStream = accept.getInputStream();

            //4.获取客户端的数据
            byte [] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println(new String(bytes,0,read));

            //5.关闭资源
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
