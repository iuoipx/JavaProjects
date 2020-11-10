package com.iuoip.inputOutputStream;

import java.io.*;

public class ReaderDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        Reader reader = null;

        try {
            reader = new FileReader(fileName);

            char[] chars = new char[1024];
            //int length = reader.read(chars);

            //判断文件是否读到结尾
            int temp = 0;
            int length = 0;
            while ((temp = reader.read()) != -1) {
                chars[length] = (char) temp;
                length++;
            }
            System.out.println(new String(chars, 0, length));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
