package com.iuoip.multiThread;

/**
 * 继承Thread类实现多线程
 */
public class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("[" + Thread.currentThread() + "]" + this.threadName + "执行线程" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
