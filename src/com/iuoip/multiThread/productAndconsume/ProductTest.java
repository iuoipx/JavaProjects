package com.iuoip.multiThread.productAndconsume;

public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product();

        new Thread(new Consumer(product)).start();
        new Thread(new Productor(product)).start();
    }

}
