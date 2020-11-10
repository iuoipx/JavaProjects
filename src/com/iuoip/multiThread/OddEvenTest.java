package com.iuoip.multiThread;

/**
 * odd even 线程输出
 */
public class OddEvenTest {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 2; i <= 100; i += 2)
                System.out.println("线程even:" + i);
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 100; i += 2)
                System.out.println("线程odd:" + i);
        }).start();
    }
}
