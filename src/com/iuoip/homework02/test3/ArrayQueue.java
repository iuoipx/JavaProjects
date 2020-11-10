package com.iuoip.homework02.test3;

public class ArrayQueue implements Queue {
    private int size;
    private int top;
    private Object[] queueArray;
    private int index;

    ////传入队列最大数据容量
    public ArrayQueue(int size) {
        this.size = size;
        this.top = -1; //记录数据量
        this.index = 0; //队列头部
        queueArray = new Object[size];
    }

    //返回元素数量
    @Override
    public int size() {
        return top + 1;
    }

    //判断是否为空
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    //入队
    @Override
    public void insert(Object element) {
        if (top >= size)
            throw new RuntimeException("queue is full");
        queueArray[++top] = element;
    }

    //出队
    @Override
    public Object remoke() {
        if (index > top)
            throw new RuntimeException("queue is empty");
        Object res = queueArray[index];
        queueArray[index++] = null;
        return res;
    }

    //获取队列的头元素
    @Override
    public Object peek() {
        if (index > top)
            throw new RuntimeException("queue is empty");
        Object res = queueArray[index];
        return res;
    }
}
