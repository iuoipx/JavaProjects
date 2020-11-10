package com.iuoip.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文本转换服务器 服务端
 */
public class TcpServer03 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务并监听端口
            ServerSocket serverSocket = new ServerSocket(7777);

            //2.获取连接
            Socket accept = serverSocket.accept();

            //获取socket的输入流和输出流
            BufferedReader bufferedIn = new BufferedReader(new InputStreamReader(accept.getInputStream()));//用于接收客户端发送的数据
//            BufferedWriter bufferedOut = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));//用于反馈数据给客户端
            PrintWriter printWriter = new PrintWriter(accept.getOutputStream(),true); //打印流

            //4.获取客户端发送的数据
            String line = null;
            while ((line = bufferedIn.readLine()) != null) { //接收-1跳出循环，关闭socket资源
                System.out.println("客户端发送的数据：" + line);
                //5.将客户端发送过来的数据转为大写后返回给客户端
//                bufferedOut.write(line.toUpperCase());
//                bufferedOut.newLine();
//                bufferedOut.flush();

                //5.1使用打印流客户端发送过来的数据转为大写后返回给客户端
                printWriter.println(line.toUpperCase());
            }

            //6.关闭资源
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
