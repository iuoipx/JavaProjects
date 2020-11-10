package com.iuoip.homework02.test3;

public class Test {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.insert("first");
        arrayQueue.insert("seconds");
        System.out.println(arrayQueue.size()); //元素个数
        System.out.println(arrayQueue.isEmpty()); //判断为空
        arrayQueue.remoke(); //头部元素出队
        System.out.println(arrayQueue.size()); //元素个数
        System.out.println(arrayQueue.peek()); //获取头部元素
        arrayQueue.remoke();
        System.out.println(arrayQueue.peek()); //空队列异常
    }
}
