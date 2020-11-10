package com.iuoip.multiThread;

/**
 * 实现Runnable接口实现多线程
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("线程3执行线程" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
