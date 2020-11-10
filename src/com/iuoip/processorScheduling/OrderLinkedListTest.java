package com.iuoip.processorScheduling;

import java.util.Scanner;

public class  OrderLinkedListTest {

    //实例一个链表，初值为空
    private static OrderLinkedList orderList = new OrderLinkedList();

    public static void main(String[] args) {

        //初始化用户输入界面和添加数据进入链表
        init();

        //模拟进程调度
        processScheduling();
    }


    /**
     * 初始化用户输入界面和将用户输入数据加入链表
     */
    private static void init() {
        //存放进程
        //给与进程个数和每个进程优先级及运行时间
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入进程数: ");
        int processCount = scanner.nextInt();
        for (int i = 1; i <= processCount; i++) {
            System.out.printf("请给定第%d个进程优先数: ", i);
            int priority = scanner.nextInt();
            System.out.printf("请给定第%d个进程要求运行时间: ", i);
            int runTime = scanner.nextInt();
            Process process = new Process(i, runTime, priority);
            //将进程加入链表
            orderList.insert(process);
        }

        System.out.println("初始链表中所有进程信息: ");
        orderList.display();
        System.out.println("-------进程调度开始-------");
    }

    /**
     * 模拟进程调度
     */
    private static void processScheduling() {
        //开启线程
        new Thread(() -> {
            while (!orderList.isEmpty()) {
                Process runningProcess = null;
                try {
                    //线程sleep一秒，此时优先级最高进程出链表被cpu选中运行，运行时间和优先级同时减一
                    Thread.sleep(1000);
                    runningProcess = orderList.pop();
                    runningProcess.setRunTime(runningProcess.getRunTime() - 1);
                    runningProcess.setPriority(runningProcess.getPriority() - 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果运行进程剩余时间大于0，重新放入链表；否则将进程状态改为 E，该进程结束运行
                if (runningProcess.getRunTime() > 0) {
                    orderList.insert(runningProcess);
                    System.out.println(runningProcess.toString() + " 正在运行");
                    System.out.println("---------------------------------------------------------------------");
                } else {
                    runningProcess.setState(Process.STATE.E);
                    System.out.println(runningProcess.toString() + "------运行结束-------");
                    System.out.println("---------------------------------------------------------------------");
                }
            }
        }).start();
    }

}
