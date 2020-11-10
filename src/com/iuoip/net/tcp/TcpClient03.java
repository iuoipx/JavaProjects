package com.iuoip.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 文本转换服务器 客户端
 */
public class TcpClient03 {
    public static void main(String[] args) {
        try {
            //1.创建socket服务，并指定服务端的ip和端口
            Socket socket = new Socket("127.0.0.1", 7777);

            //2.获取流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //用于获取从键盘录入的数据
            //BufferedWriter bufferedOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//用于向服务端发送数据
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);//打印流
            BufferedReader bufferedIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));//用于获取服务端返回的数据

            //3.获取从键盘录入的数据，发给服务器端
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if ("over".equalsIgnoreCase(line)) {
                    break;
                }
                //4.向服务端发送数据
//                bufferedOut.write(line);
//                bufferedOut.newLine(); //结束符
//                bufferedOut.flush(); //刷新缓冲区，刷新后数据会发送出去

                //4.1使用打印流向服务端发送数据
                printWriter.println(line);

                //5.接收服务端返回的数据
                String result = bufferedIn.readLine();
                System.out.println("服务端返回的数据：" + result);
            }

            //6.关闭资源
            bufferedReader.close();
            socket.close();  //close后向服务端发送-1
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
