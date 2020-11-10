package com.iuoip.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {
    public static void main(String[] args) {

        //存的对象类型如果是自定义类型，需要重写equals方法
        HashSet<Person> hashSet = new HashSet<>();

        //无序，唯一
        hashSet.add(new Person(1, "gx1", "sb", "man"));
        hashSet.add(new Person(2, "gx1", "sb", "man"));
        hashSet.add(new Person(3, "gx1", "sb", "man"));
        hashSet.add(new Person(2, "gx1", "sb", "man"));
        hashSet.add(new Person(5, "gx1", "sb", "man"));

        Iterator<Person> iterator = hashSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
