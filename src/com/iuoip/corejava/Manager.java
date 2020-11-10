package com.iuoip.corejava;

import java.time.LocalDate;

public class Manager extends Employee {

    private double bonus;

    /**
     * @param name the employee's name
     * @param salary the salary
     * @param hireDay the hireDay
     */
    public Manager(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
        this.bonus = 0;
    }


    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
