package com.iuoip.corejava;

import java.time.LocalDate;

/*不允许扩展的类被称为final类
  类中声明为final的方法不能被子类覆盖
  final类中的所有方法自动成为final方法，不包括字段
 */
public final class Executive extends Manager {

    /**
     * @param name    the employee's name
     * @param salary  the salary
     * @param hireDay the hireDay
     */
    public Executive(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
    }


}
