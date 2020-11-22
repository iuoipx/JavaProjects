package com.iuoip.corejava.interfaces;

import com.iuoip.corejava.Employee;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 实现Comparable接口实现员工薪资排序
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("harry hacker", 35000);
        staff[1] = new Employee("spiker", 75000);
        staff[2] = new Employee("tony tester", 38000);

        Arrays.sort(staff);

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

        Comparable x;
        x = new Employee("asd", 123);
        System.out.println(x instanceof Comparable);

        Path path = Paths.get("jdk-12", "conf", "sec"); //class
        System.out.println(path); //jdk-12\conf\sec

        Path of = Path.of("jdk-12", "conf", "sec"); //interface
        System.out.println(of); //jdk-12\conf\sec

        String[] words = {"shinobu", "asd", "gxsb"};
        Arrays.sort(words,new LengthComparator());
        for(String s : words)
            System.out.println(s);
    }
}

interface Iterator<E> {
    boolean hasNext();

    E next();

    //默认方法用途，遍历不可读数据结构时使用remove方法将抛出异常
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}

interface Collection {
    int size();

    //默认方法调用其他方法
    default boolean isEmpty() {
        return size() == 0;
    }
}

//默认方法冲突问题
interface Person {
    //提供默认实现
    default String getName() {
        return "";
    }
}

interface Named {
    //不论是否提供默认实现，都会出现冲突。
    String getName();
//    default String getName() {
//        return getClass().getName() + "_" + hashCode();
//    }
}

class Student implements Person, Named {
    //提供一个getName方法，选择冲突方法中的一个
    @Override
    public String getName() {
        return Person.super.getName();
    }
}

//定义一个实现Comparator<String>接口的类，并重写compare方法
class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        return s.length() - t1.length();
    }
}
