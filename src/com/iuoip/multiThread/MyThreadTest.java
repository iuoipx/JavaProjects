package com.iuoip.multiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
        myThread1.start();

        myThread1.setName("自定义线程名");
        System.out.println("---" + myThread1.getName() + "---");

        myThread2.start();
//        myThread1.start();  //IllegalThreadStateException

        //2.1
        new Thread(new MyRunnable()).start();

        //2.2 lambda
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(50);
                    System.out.println("lambda表达式线程: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //3.
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask<String>(myCallable);
        new Thread(futureTask).start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
                System.out.println("主线程执行:" + i + "线程名：" + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            String str = (String) futureTask.get();
            System.out.println("Callable call()返回值: " + str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
