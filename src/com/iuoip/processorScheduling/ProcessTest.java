package com.iuoip.processorScheduling;

import java.util.Scanner;

public class ProcessTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入进程数: ");
        int processCount = scanner.nextInt();
        for (int i = 1; i <= processCount; i++) {
            System.out.printf("请给定第%d个进程优先数: ", i);
            int runTime = scanner.nextInt();
            System.out.printf("请给定第%d个进程要求运行时间: ", i);
            int priority = scanner.nextInt();
            Process process = new Process(i, runTime, priority);
            System.out.println(process.toString());
        }
    }
}
