package com.iuoip.collection;

public class GenericTest {
    public static void main(String[] args) {
        Generic generic = new Generic(10);
        generic.addData(1, "ads");
        generic.addData(2, 12);

        String data1 = (String) generic.getData(1);
        try {
            String data2 = (String) generic.getData(2);//error 类型转换异常
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        System.out.println(data1);
    }
}
