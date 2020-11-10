package com.iuoip.exception;

import java.util.Date;

//类型转换异常
public class ClassCastExceptionDemo {
    public static void main(String[] args) {
        Object obj = new Date();
        ClassCastExceptionDemo classCastExceptionDemo = (ClassCastExceptionDemo) obj;
    }
}
