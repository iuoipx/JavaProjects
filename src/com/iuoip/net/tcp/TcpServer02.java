package com.iuoip.net.tcp;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端和服务端进行数据交互
 */
public class TcpServer02 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务并监听端口
            ServerSocket serverSocket = new ServerSocket(9999);

            //2.获取连接
            Socket accept = serverSocket.accept();

            //3.获取socket的输入流和输出流
            InputStream inputStream = accept.getInputStream(); //用于接收客户端发送的数据
            OutputStream outputStream = accept.getOutputStream(); //用于给客户端反馈数据


            //4.获取客户端发送的数据
            byte[] bytes = new byte[1024];
            while (true) {
                int read = inputStream.read(bytes);
                if (new String(bytes).equals("886"))
                    break;
                System.out.println("客户端发送的数据: " + new String(bytes, 0, read));

                //5.反馈数据给客户端
                outputStream.write(bytes.toString().toUpperCase().getBytes());
            }

            //6.关闭资源
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
