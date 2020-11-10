package com.iuoip.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("gx");
        hashSet.add("sb");
        hashSet.add("gx");
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        System.out.println(hashSet.contains("sb"));

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next());
    }
}
