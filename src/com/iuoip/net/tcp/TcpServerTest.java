package com.iuoip.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerTest {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6777);

            Socket accept = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File("serverCopy.txt")), true);
            PrintWriter out = new PrintWriter(accept.getOutputStream(),true);

            String line = null;
            while ((line = in.readLine()) != null) {
                printWriter.println(line);
            }
            out.println("data upload success");

            printWriter.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
