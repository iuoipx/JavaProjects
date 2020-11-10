package com.iuoip.inputOutputStream;

import java.io.*;

public class InputStreamDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);

            //byte[] bytes = new byte[(int) file.length()]; //用bytes数组存放数据
            //int length = inputStream.read(bytes); //从流中读出数据存放到数组中

            byte[] bytes = new byte[1024];
            int temp = 0;
            int length = 0;

            //判断文件是否到达结尾
            while ((temp = inputStream.read()) != -1) {
                bytes[length] = (byte) temp;
                length++;
            }

            System.out.println(new String(bytes, 0, length));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
