package com.iuoip.inputOutputStream;

import java.io.IOException;

public class PipedStreamTest {
    public static void main(String[] args) {
        PipedOutputStreamDemo pipedOutputStreamDemo = new PipedOutputStreamDemo();
        PipedInputStreamDemo pipedInputStreamDemo = new PipedInputStreamDemo();

        try {
            //管道输出流和管道输入了进行连接
            pipedOutputStreamDemo.getPipedOutputStream().connect(pipedInputStreamDemo.getPipedInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //开启线程
        new Thread(pipedOutputStreamDemo).start();
        new Thread(pipedInputStreamDemo).start();
    }
}
