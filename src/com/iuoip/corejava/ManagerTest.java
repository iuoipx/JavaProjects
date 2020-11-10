package com.iuoip.corejava;

import java.time.LocalDate;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("shinobu", 10000, LocalDate.now());
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("inroi", 5000, LocalDate.now());
        staff[2] = new Employee("gxsb", 4000, LocalDate.now());

        /*当e引用不同对象时，调用的是不同类中的方法，虚拟机知道e实际引用的对象类型，
          因此能够正确地调用相应的方法。
         */
        for (Employee e : staff) {
            System.out.println(e.getName() + " " + e.getSalary());
        }
        /*
        一个对象变量可以指示多种实际类型的现象称为多态。
        在运行时能够自动地选择适当的方法，称为动态绑定。
         */
    }
}
