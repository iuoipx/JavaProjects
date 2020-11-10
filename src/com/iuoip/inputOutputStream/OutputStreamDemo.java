package com.iuoip.inputOutputStream;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        OutputStream outputStream = null;

        try {
            //创建字节输出流对象
            outputStream = new FileOutputStream(file, true); //如果文件不存在，自动创建
            String str = "1811";

            byte[] bytes = str.getBytes(); //字符转为字节数组

            //1.字节数组写入
            outputStream.write(bytes);

            //2.单个字节写入
            for (int i = 0; i < bytes.length; i++) {
                outputStream.write(bytes[i]);
            }
            System.out.println("data write success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
