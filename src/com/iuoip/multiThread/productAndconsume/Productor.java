package com.iuoip.multiThread.productAndconsume;

public class Productor implements Runnable {

    private Product product = null;

    //通过构造函数传入同一个操作对象
    public Productor(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)Math.random()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product.addProducts();
    }
}
