package com.iuoip.processorScheduling;

public class OrderLinkedList {
    private Node head;  //头结点

    private class Node {
        private Process process;
        private Node next;

        public Node(Process process) {
            this.process = process;
        }
    }

    public OrderLinkedList() {
        this.head = null;
    }

    //将进程插入链表且排序
    public void insert(Process process) {
        Node node = new Node(process);
        Node pre = null;     //记录插入进程的前一个元素
        Node current = head; //记录插入进程之前的元素
        //按优先数排序,找到插入进程的位置
        while (current != null && process.getPriority() < current.process.getPriority()) {
            pre = current;
            current = current.next;
        }
        //代表第一次或者插入元素优先级最高
        if (pre == null) {
            head = node;
            head.next = current;
        } else {
            pre.next = node;
            node.next = current;
        }
    }

    //取出头部进程，即返回该进程
    public Process pop() {
        Process process = head.process;
        head = head.next;
        return process;
    }

    //删除头部进程
    public void deleteHead() {
        head = head.next;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return head == null;
    }

    //显示所有进程
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.process + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
