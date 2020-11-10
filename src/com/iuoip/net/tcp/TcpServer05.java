package com.iuoip.net.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 序列化对象服务器端
 */
public class TcpServer05 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            //2.获取socket连接
            Socket accept = serverSocket.accept();
            String ip = accept.getInetAddress().getHostAddress();
            System.out.println(ip + "...connected");

            //3.获取流对象
            //对象输入流，接收客户端发送的对象
            ObjectInputStream in = new ObjectInputStream(accept.getInputStream());
            //打印流，向客户端反馈结果
            PrintWriter out = new PrintWriter(accept.getOutputStream(), true);

            //4.开始获取客户端发送的对象，进行反序列化
            User user = (User) in.readObject();
            System.out.println(user.getName()+":"+user.getAge());

            //5.向客户端反馈结果
            out.println("反序列化成功");

            //6.关闭资源
            accept.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

