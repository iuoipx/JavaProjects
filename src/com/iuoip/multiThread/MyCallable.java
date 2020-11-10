package com.iuoip.multiThread;

import java.util.concurrent.Callable;

/**
 * 实现Callable接口
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println("子线程执行：" + i);
        }
        return "子线程结束";
    }
}
