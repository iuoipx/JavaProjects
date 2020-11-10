package com.iuoip.collection;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "ac1");
        hashMap.put(1, "ac2");
        hashMap.put(2, "ac3");
        hashMap.put(2, "ac4");
        hashMap.put(3, "ac1");

        Set<Integer> integers = hashMap.keySet();//获取所有key
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();

        Collection<String> values = hashMap.values();//获取所有value
        Iterator<String> iterator1 = values.iterator();
        while (iterator1.hasNext())
            System.out.println(iterator1.next());

        //获取数据
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, String> next = iterator2.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
}
