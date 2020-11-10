package com.iuoip.exception;

//空指针异常
public class NullPointerExceptionDemo {
    private int i = 0;

    public static void main(String[] args) {
        NullPointerExceptionDemo nullPointerExceptionDemo = new NullPointerExceptionDemo();
        nullPointerExceptionDemo = null;
        System.out.println(nullPointerExceptionDemo.i);
    }
}
