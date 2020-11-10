package com.iuoip.multiThread.productAndconsume;

public class Product {

    private int products = 5; //资源在某一时间段只能有一个对象进行操作
    private final int maxCount = 20;

    //商品放满了才允许被消费
    public synchronized void addProducts() {
        while (true) {
            if (products >= maxCount) {
                try {
                    wait();  //线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                products++;
                System.out.println("生产者生产1个产品，当前产品:" + products);
                notifyAll();
            }
        }
    }

    //消费空了才能继续生产进货
    public synchronized void getProduct() {
        while (true) {
            if (products <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                products--;
                System.out.println("消费者消费1个产品，剩余产品：" + products);
                notifyAll();
            }
        }
    }
}
