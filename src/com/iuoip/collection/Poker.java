package com.iuoip.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Poker {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        String[] pokerColor = {"red", "black", "plum", "square"};

        String[] pokerNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int i = 0; i < pokerColor.length; i++)
            for (int j = 0; j < pokerNum.length; j++)
                arrayList.add(pokerColor[i] + pokerNum[j]);
        arrayList.add("king");
        arrayList.add("queen");

        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> bottomPoker = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++)
            if (i < 3)
                bottomPoker.add(arrayList.get(i));
            else if (i % 3 == 0)
                player01.add(arrayList.get(i));
            else if (i % 3 == 1)
                player02.add(arrayList.get(i));
            else
                player03.add(arrayList.get(i));


        look("1", player01);
        look("2", player01);
        look("3", player01);
    }

    private static void look(String name, ArrayList<String> arrayList){
        Iterator<String> iterator = arrayList.iterator();
        
    }
}
