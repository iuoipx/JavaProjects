package com.iuoip.homework01;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个不多于5位的正整数：");
        int num = scanner.nextInt();

        int[] arr = new int[5]; //数组保存逆序数据
        int i;
        for (i = 0; i < arr.length; i++) {
            arr[i] = num % 10;
            if (arr[i] == 0) {
                System.out.printf("这是一个%d位数,", i);
                System.out.print("逆序输出为：");
                break;
            }
            num /= 10;
        }

        for (int j = 0; j < i; j++)
            System.out.print(arr[j]);

    }
}
