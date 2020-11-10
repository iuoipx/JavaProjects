package com.iuoip.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端和服务端进行数据交互
 */
public class TcpClient02 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，并指定服务端的ip和端口port
            Socket socket = new Socket("127.0.0.1", 9999);

            //2.获取socket的输入流和输出流
            OutputStream outputStream = socket.getOutputStream(); //用于向服务端发送数据
            InputStream inputStream = socket.getInputStream(); //用于接收服务端返回的数据

            Scanner scanner = new Scanner(System.in);
            byte[] bytes = new byte[1024];

            while (true) {
                //3.准备数据并发送给服务端
                String str = scanner.nextLine();
                if (str.equals("886"))
                    break;
                outputStream.write(str.getBytes());

                //4.接收服务端返回数据
                int read = inputStream.read(bytes);
                System.out.println("服务端返回的数据: " + new String(bytes, 0, read));
            }



            //5.关闭资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
