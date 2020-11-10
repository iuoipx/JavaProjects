package com.iuoip.homework02.test1.coach;

import com.iuoip.homework02.test1.Learning;

public class PingpongCoach extends Coach implements Learning {
    @Override
    public void leariningEnglish() {
        System.out.println("PingpongCoach leariningEnglish...");
    }

    @Override
    public void teach() {
        System.out.println("PingpongCoach teach...");
    }
}
