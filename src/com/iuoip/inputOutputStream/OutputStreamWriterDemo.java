package com.iuoip.inputOutputStream;

import java.io.*;

/**
 * 字符输出流对象转字节输出流对象
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        OutputStreamWriter outputStreamWriter = null;

        try {
            //创建outputStreamWriter对象，outputStreamWriter构造函数参数是一个字节输出流对象
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));

            String str = "2020 year 10 month 13 day";
            outputStreamWriter.write(str);
            System.out.println("data write success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
