package com.iuoip.homework02.test2;

public class ArrayStack implements Stack {
    private int size;
    private int top;
    private Object[] stackArray;

    //构造函数，传入栈的最大元素容量
    public ArrayStack(int size) {
        this.size = size;
        this.top = -1;  //表示空栈
        this.stackArray = new Object[size];
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

    //入栈
    @Override
    public void push(Object element) {
        if (top >= size)
            throw new RuntimeException("stack is full");
        this.stackArray[++top] = element;
    }

    //出栈
    @Override
    public Object pop() {
        if (top < 0)
            throw new RuntimeException("stack is empty");
        return stackArray[top--];
    }

    //获取栈顶元素
    @Override
    public Object peek() {
        if (top < 0)
            throw new RuntimeException("stack is empty");
        return stackArray[top];
    }
}
