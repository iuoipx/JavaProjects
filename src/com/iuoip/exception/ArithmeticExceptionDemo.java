package com.iuoip.exception;

public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        int res = 0;
        try {
            res = divide(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
            e.printStackTrace();
        }

        int res2 = 0;
        //捕获手动异常
        try {
            res2 = divide2(3, 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        
        System.out.printf("%d,%d", res, res2);
    }

    /*
        throws
        用在方法声明后面，跟着异常类名
        表示抛出异常，由该方法的调用者处理
        表示出现异常的一种可能性，并不一定会发生
    */
    public static int divide(int x, int y) throws ArithmeticException {
        return x / y;
    }

    /*
        throw
        用在方法体内，跟着异常对象名
        表示抛出异常，由方法体内的语句处理
        执行 throw 一定抛出了某种异常
    */
    //手动抛出异常
    public static int divide2(int x, int y) {
        if (y == 0)
            throw new ArithmeticException("can't be zero div");
        return x / y;
    }
}
