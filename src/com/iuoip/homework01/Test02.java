package com.iuoip.homework01;

import java.util.Scanner;


public class Test02 {
    static Boolean isPrime(int n) {   //质数判断
        Boolean isPrime = true;
        for (int i = 2; i < n; i++)
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        return isPrime;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个2-1000的正整数：");
        int num = scanner.nextInt();

        if (isPrime(num))
            System.out.printf("%d = %d", num, num);
        else
            System.out.printf("%d = ", num);

        int n = num / 2;
        for (int i = 2; i <= n; i++) {
            if (num != 1 && isPrime(i)) {
                while (num % i == 0) {
                    num /= i;
                    if (num == 1) { 
                        System.out.print(i);
                    } else {
                        System.out.print(i + " x ");
                    }
                }
            }
        }

    }
}
