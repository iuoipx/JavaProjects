package com.iuoip.multiThread.saveMoney;

public class SaveMoneyTest {
    public static void main(String[] args) {
        SaveMoney saveMoney = new SaveMoney();
        new Thread(saveMoney, "account1").start();
        new Thread(saveMoney, "account2").start();
    }
}
