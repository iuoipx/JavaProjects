package com.iuoip.exception;

//数组越界
public class ArrayIndexOutOfBoundsExceptionDemo {
    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "ccc"};
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(arr[i]);
            }
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
