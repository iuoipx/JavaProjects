package com.iuoip.multiThread;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {

    private int ticket = 20;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);

//                synchronized (this) {
                lock.lock();
                if (ticket > 0)
                    System.out.println(Thread.currentThread().getName() + "卖出了" + ticket-- + "号票");
                else
                    break;
//                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }
}
