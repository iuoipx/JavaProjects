package com.iuoip.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                if (person.getId() > t1.getId())
                    return 1;
                return 0;
            }
        });

        treeSet.add(new Person(1, "gx1", "sb", "man"));
        treeSet.add(new Person(3, "gx1", "sb", "man"));
        treeSet.add(new Person(2, "gx1", "sb", "man"));
        treeSet.add(new Person(2, "gx1", "sb", "man"));

        Iterator<Person> iterator = treeSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
