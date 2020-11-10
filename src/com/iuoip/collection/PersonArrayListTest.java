package com.iuoip.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonArrayListTest {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList();
        arrayList.add(new Person(1, "gx1", "sb", "man"));
        arrayList.add(new Person(2, "gx2", "sb", "man"));
        arrayList.add(new Person(3, "gx3", "sb", "man"));

//        for (Person person : arrayList)
//            System.out.println(person.toString());

        Iterator<Person> iterator = arrayList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
