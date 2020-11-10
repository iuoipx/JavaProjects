package com.iuoip.inputOutputStream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PipedOutputStreamDemo implements Runnable {
    private PipedOutputStream pipedOutputStream;

    public PipedOutputStreamDemo() {
        this.pipedOutputStream = new PipedOutputStream();
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    @Override
    public void run() {
        String str = "湖北师范大学";
        byte[] bytes = str.getBytes(); //字符转字节
        try {
            pipedOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
