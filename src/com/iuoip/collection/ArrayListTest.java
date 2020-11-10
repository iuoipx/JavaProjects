package com.iuoip.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        //添加元素
        arrayList.add("gxsb");
        arrayList.add(null);
        arrayList.add(123);
        //对应索引插入元素
        arrayList.add(2, "gxdsb");
        arrayList.add(123);
        System.out.println(arrayList);

        //返回boolean，是否存在元素
        System.out.println(arrayList.contains(123));

        //返回索引对应元素
        System.out.println(arrayList.get(2));

        //返回元素第一次出现的索引
        System.out.println(arrayList.indexOf(123));

        //是否为空
        System.out.println(arrayList.isEmpty());

        //替换指定索引元素
        arrayList.set(1, "sbgx");
        System.out.println(arrayList);

        //集合元素长度
        System.out.println(arrayList.size());

        System.out.println("----for遍历集合元素----");
        for (int i = 0; i < arrayList.size(); i++)
            System.out.print(arrayList.get(i));
        System.out.println();

        System.out.println("--for each遍历集合元素--");
        for (Object object : arrayList)
            System.out.print(object);
        System.out.println();

        System.out.println("--Iterator迭代器遍历集合元素--");
        Iterator iterator = arrayList.iterator(); //获取集合迭代器
        while (iterator.hasNext())
            System.out.print(iterator.next());  //使用迭代器获取集合元素
        System.out.println();
    }
}
