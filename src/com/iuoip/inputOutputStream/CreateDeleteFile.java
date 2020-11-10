package com.iuoip.inputOutputStream;

import java.io.File;
import java.io.IOException;

public class CreateDeleteFile {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "iuoip" + File.separator + "shinobu.txt";
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
            System.out.println("file delete success");
        } else {
            try {
                file.createNewFile();
                System.out.println("file create success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
