package com.iuoip.homework02.test1.player;

import com.iuoip.homework02.test1.Learning;

public class PingpongPlayer extends Player implements Learning {
    @Override
    public void study() {
        System.out.println("PingpongPlayer study...");
    }

    @Override
    public void leariningEnglish() {
        System.out.println("PingpongPlayer leariningEnglish...");
    }
}
