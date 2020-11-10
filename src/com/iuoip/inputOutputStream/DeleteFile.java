package com.iuoip.inputOutputStream;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("file isn't exist...");
        }
    }
}
