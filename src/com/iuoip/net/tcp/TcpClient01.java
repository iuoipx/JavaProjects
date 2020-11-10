package com.iuoip.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端发送一次数据，服务端接收一次数据
 */
public class TcpClient01 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，并指定服务端ip和端口port
            Socket socket = new Socket("127.0.0.1",8888);

            //2.获取socket输出流，向服务器端发送数据
            OutputStream outputStream = socket.getOutputStream();

            //3.准备数据，发送数据
            byte[] buf = "????".getBytes();
            outputStream.write(buf);

            //4.关闭资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
