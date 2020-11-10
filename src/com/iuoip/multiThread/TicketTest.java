package com.iuoip.multiThread;

/**
 * 3个窗口卖票
 */
public class TicketTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}
