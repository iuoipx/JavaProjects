package com.iuoip.corejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = {"Shinobu", "Ads", "Gxsb", "Mars", "Inori"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, sencod) -> first.length() - sencod.length());
        System.out.println(Arrays.toString(planets));

        Timer timer = new Timer(1000, event -> System.out.println("the time is" + new Date()));
        timer.start();

        Timer timer1 = new Timer(1000, event -> {
            System.out.println("at the tone,the time is "
                    + Instant.ofEpochMilli(event.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        });



        //        (String first, String second) -> {
//            if (first.length() < second.length()) return -1;
//            else if (first.length() > second.length()) return 1;
//            else return 0;
//        }
//
//        () -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(i);
//            }
//        }

        //如果可以推导出一个lambda表达式的参数类型，则可以忽略且类型。
        Comparator<String> comp = (first, second) -> first.length();

        //如果方法只有一个参数，而且这个参数的类型可以推导的出，还可以省略小括号
        ActionListener listener = event -> System.out.println("the time is" +
                Instant.ofEpochMilli(event.getWhen()));

        //无需指定lambda表达式的返回类型。lambda的返回类型总是会由上下文推导得出
//        (String first, String second) -> first.length() - second.length();

//        (int x) -> {
//            if (x >= 0) return 1;
//        }
    }
}
