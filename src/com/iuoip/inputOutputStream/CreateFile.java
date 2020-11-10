package com.iuoip.inputOutputStream;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "iuoip" + File.separator + "shinobu.txt");
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
