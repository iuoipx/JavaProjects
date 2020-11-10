package com.iuoip.homework02.test2;

public class Test {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("first");
        arrayStack.push("seconds");
        System.out.println(arrayStack.size()); //元素个数
        System.out.println(arrayStack.isEmpty()); //判断为空
        arrayStack.pop();  //顶部出栈
        System.out.println(arrayStack.size()); //元素个数
        System.out.println(arrayStack.peek()); //获取顶部元素
        arrayStack.pop();
        arrayStack.peek(); //空栈异常抛出
    }
}
