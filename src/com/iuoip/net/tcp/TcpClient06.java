package com.iuoip.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 图片上传
 */
public class TcpClient06 {
    public static void main(String[] args) {
        try {

            if (args.length != 1) {
                System.out.println("请上传.png格式图片");
                return;
            }

            File file = new File(args[0]);

            if (!file.exists() && !file.isFile()) {
                System.out.println("文件有问题");
                return;
            }

            if (file.getName().endsWith(".png")) {
                System.out.println("图片格式错误");
                return;
            }

            if (file.length() > 1024 * 1024 * 5) {
                System.out.println("图片太大");
                return;
            }

            //1.创建socket服务，指定服务器端ip和端口
            Socket socket = new Socket("127.0.0.1", 8888);

            //2.获取流对象
            //文件输入流，读取图片内容
            FileInputStream fis = new FileInputStream(file);
            //socket输出流，将图片内容发送给服务器端
            OutputStream out = socket.getOutputStream();
            //socket输入流，用于接收服务器端返回的结果
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //3.读取图片内容，
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                //4.将内容发送给服务器端
                out.write(bytes, 0, len);
            }

            socket.shutdownOutput();

            //5.获取服务器端的反馈结果
            String result = in.readLine();
            System.out.println(result);

            //6.关闭资源
            fis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
