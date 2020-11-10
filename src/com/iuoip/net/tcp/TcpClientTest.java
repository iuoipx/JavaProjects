package com.iuoip.net.tcp;

import java.io.*;
import java.net.Socket;

public class TcpClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 6777);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("copy.txt"))));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                out.println(line);
            }
            socket.shutdownOutput();

            String result = in.readLine();
            System.out.println(result);

            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
