package com.iuoip.inputOutputStream;

import java.io.*;

/**
 * 字节输入流对象转字符输入流对象
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream((file)));

            char[] chars = new char[1024];
            int length = inputStreamReader.read(chars);//将流中数据读到数组中

            System.out.println(new String(chars,0,length));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
