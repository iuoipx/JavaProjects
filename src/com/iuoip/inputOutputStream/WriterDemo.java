package com.iuoip.inputOutputStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        Writer writer = null;

        try {
            writer = new FileWriter(fileName,true);
            String str = "\r\n计信1811";
            writer.write(str);
            System.out.println("data write success");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
