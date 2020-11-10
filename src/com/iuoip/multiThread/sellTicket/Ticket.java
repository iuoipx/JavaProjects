package com.iuoip.multiThread.sellTicket;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {

    private int ticket = 20;  //线程共享资源

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);

//                synchronized (this) {
                lock.lock();
                //保证线程安全的代码

                //操作共享资源的代码
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
