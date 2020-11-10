package com.iuoip.multiThread.saveMoney;

import java.util.concurrent.locks.ReentrantLock;

public class SaveMoney implements Runnable {

    private double money = 0;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            money += 1000;
            System.out.println(Thread.currentThread().getName() + "存入1000，当前余额: " + money);
            lock.unlock();
        }
    }
}
