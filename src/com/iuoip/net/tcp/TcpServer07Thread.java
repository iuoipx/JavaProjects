package com.iuoip.net.tcp;

import java.io.*;
import java.net.Socket;

public class TcpServer07Thread implements Runnable {
    private Socket socket;

    public TcpServer07Thread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String ip = socket.getInetAddress().getHostAddress();
        int count = 0;
        try {
            File file = new File("E:\\" + ip + ".png");
            while (file.exists()) {
                file = new File("E:\\" + ip + "(" + ++count + ")" + ".png");
            }
            //获取流对象
            InputStream in = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //读取客户端发送的数据，并写到文件中
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            //向客户端反馈数据
            out.println(ip + ": image upload success");

            //关闭资源
            fos.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(ip + ": image upload failed");
        }

    }
}
