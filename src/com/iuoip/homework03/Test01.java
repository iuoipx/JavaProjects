package com.iuoip.homework03;

import java.io.*;

public class Test01 {
    public static void main(String[] args) {
        String poemStr = "  静夜思\r\n窗前明月光，\r\n疑是地上霜。\r\n举头望明月，\r\n低头思故乡。";
        String filePath1 = "E:" + File.separator + "poem1.txt";
        String filePath2 = "E:" + File.separator + "poem2.txt";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);

        //先删除已经存在的文件
        if (file1.exists() || file2.exists()) {
            file1.delete();
            file2.delete();
        }

        //声明字节输入输出流对象
        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        InputStream inputStream = null;

        try {
            //创建字节输入输出流对象，并把字节写入文件的末尾
            outputStream1 = new FileOutputStream(file1, true);
            outputStream2 = new FileOutputStream(file2, true);
            inputStream = new FileInputStream(file1);
            byte[] writeBytes = poemStr.getBytes();  //字符转字节

            //写入第一个文件
            for (int i = 0; i < writeBytes.length; i++)
                outputStream1.write(writeBytes[i]);

            //从第一个文件读取数据
            byte[] readBytes = new byte[(int) file1.length()];
            int length = inputStream.read(readBytes);
            System.out.println(new String(readBytes,0,length));
            //写入第二个文件
            outputStream2.write(readBytes);
            System.out.println("data write success");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream1.close();
                outputStream2.close();
                inputStream.close();
                System.out.println("字节流关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
