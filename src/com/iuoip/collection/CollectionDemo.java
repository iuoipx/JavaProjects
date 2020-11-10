package com.iuoip.collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("asd");
        arrayList.add("gxsb");

        Collections.addAll(arrayList, "hbnu", "sbfgx");
        System.out.println(arrayList);

        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }
}
