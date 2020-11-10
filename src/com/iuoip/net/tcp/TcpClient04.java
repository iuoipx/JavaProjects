package com.iuoip.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 文本文件上传
 */
public class TcpClient04 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，指定服务器端ip和端口
            Socket socket = new Socket("127.0.0.1", 9999);

            //2.获取流对象
            //获取文件输入流，读取文件内容
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(".\\src\\jdbc.properties")));
            //获取socket输出流，向服务器端发送数据
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //获取socket输入流，获取服务器端返回的结果数据
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //使用时间戳作为服务器端文件读取结束对象
//            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//            long time = System.currentTimeMillis(); //获取当前时间戳
//            dos.writeLong(time);

            //3.读取文件，并将文件内容上传至服务器端
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //4.向服务器端发送数据
                out.println(line);
            }
//            out.println("over");
//            out.println(time + "");
            //关闭socket输出流
            socket.shutdownOutput();


            //5.获取服务器端返回的结果
            String result = in.readLine();
            System.out.println(result);

            //6.关闭资源
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
