package com.iuoip.homework03;

import java.io.*;
import java.nio.charset.Charset;

public class Test02 {
    public static void main(String[] args) {
        String poemStr = "  静夜思\r\n窗前明月光，\r\n疑是地上霜。\r\n举头望明月，\r\n低头思故乡。";
        String filePath = "E:" + File.separator + "poem3.txt";
        File file = new File(filePath);

        //先删除已经存在的文件
        if (file.exists()) {
            file.delete();
        }

        OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;

        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "GBK");
            inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");

            //使用GBK格式写入文件
            outputStreamWriter.write(poemStr);
            outputStreamWriter.close();

            //将GBK格式文件转为utf-8格式文件
            codeConvert(file);   //去掉之后乱码

            //按utf-8格式读取文件
            char[] chars = new char[1024];
            int length = inputStreamReader.read(chars);
            inputStreamReader.close();

            //把char转为String
            String str = new String(chars);
            System.out.println(str);   //文件格式转换之前输出乱码

            //使用utf-8格式写入文件
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            outputStreamWriter.write(str);
            System.out.println("data write success");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //GBK格式文件转utf-8格式文件
    public static void codeConvert(File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream(file), Charset.forName("GBK")));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream(file), Charset.forName("UTF-8")));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
