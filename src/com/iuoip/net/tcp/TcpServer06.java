package com.iuoip.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 图片上传
 */
public class TcpServer06 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务并监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            //2.获取socket连接
            Socket accept = serverSocket.accept();

            //3.获取流对象
            //socket输入流，获取从客户端接收的内容
            InputStream in = accept.getInputStream();
            //socket输出流，向服务器端反馈结果
            PrintWriter out = new PrintWriter(accept.getOutputStream(), true);
            //文件输出流，向文件中写入内容
            FileOutputStream fos = new FileOutputStream("E:\\test.png");

            //4.读取客户端发送的数据，并将数据写入到文件中
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                //5.将读取的内容写入文件
                fos.write(bytes, 0, len);
            }

            //6.向客户端反馈结果
            out.println("image upload success");

            //7.关闭资源
            fos.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
