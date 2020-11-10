package com.iuoip.multiThread.productAndconsume;

public class Consumer implements Runnable {

    private Product product = null;

    //通过构造函数传入同一个操作对象
    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)Math.random()*2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product.getProduct();
    }
}
