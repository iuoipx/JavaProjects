package com.iuoip.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文本上传
 */
public class TcpServer04 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，监听端口
            ServerSocket serverSocket = new ServerSocket(9999);

            //2.获取socket连接
            Socket accept = serverSocket.accept(); //阻塞式方法

            //3.获取流对象
            //获取socket输入流，接收客户端发送的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            //获取socket输出流，向客户端反馈信息
            PrintWriter out = new PrintWriter(accept.getOutputStream(), true);
            //获取文件输出流，向文件写入内容
            PrintWriter printWriter = new PrintWriter(new FileWriter("E:\\shinobu.txt"), true);

//            DataInputStream dis = new DataInputStream(accept.getInputStream());
//            long time = dis.readLong();

            //4.获取文件内容，并将客户端的文件内容保存到服务端文件
            String line = null;
            while ((line = in.readLine()) != null) { //读到-1时null
//                if (line.equalsIgnoreCase("over")) { //自定义结束标记
//                    break;
//                }
//                if ((time + "").equals(line)) {  //时间戳结束标记
//                    break;
//                }
                //5.向文件中写数据
                printWriter.println(line);
            }

            //6.向客户端反馈数据
            out.println("file upload success");

            //7.关闭资源
            printWriter.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
