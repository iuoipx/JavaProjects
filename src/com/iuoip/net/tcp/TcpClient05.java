package com.iuoip.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 序列化对象，并通过网络进行传输
 */
public class TcpClient05 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，指定服务器端的ip和端口
            Socket socket = new Socket("127.0.0.1", 8888);

            //2.获取流对象
            //对象输出流，将对象发送给服务器端
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //socket输入流，获取服务器端反馈的结果
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //3.开始发送对象给服务器端
            User user = new User();
            user.setName("gxsb");
            user.setAge(20);
            out.writeObject(user);

            //4.接收服务器端反馈的结果
            String result = in.readLine();
            System.out.println(result);

            //5.关闭资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
