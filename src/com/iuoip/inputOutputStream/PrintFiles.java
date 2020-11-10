package com.iuoip.inputOutputStream;

import java.io.File;

public class PrintFiles {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip";
        File file = new File(fileName);

        printAllFile(file);
    }

    private static void printAllFile(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles(); //获取当前目录所有文件
                for (File f : files
                ) {
                    printAllFile(f);
                }
            }else{
                if(file.getAbsolutePath().endsWith(".txt")){
                    System.out.println(file);
                }
            }
        }
    }
}
