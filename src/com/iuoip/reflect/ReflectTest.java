package com.iuoip.reflect;

import com.iuoip.serializable.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        Person person = new Student("gxsb", 20, "20171321");

        //1.通过类名.class
        Class aClass1 = Student.class;

        //2.通过对象的getClass()获取字节码对象
        Class aClass2 = person.getClass();

        //3.通过Class类的forName()
        Class aClass3 = null;
        try {
            aClass3 = Class.forName("com.iuoip.reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());


        Constructor constructor = null;
        Person person1 = null;
        try {
            //通过反射获取构造方法
            constructor = aClass3.getConstructor(String.class, int.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            //1.通过构造方法创建对象
            person1 = (Person) constructor.newInstance("shinobu", 12, "2012313");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Person person2 = null;
        try {
            //2.通过字节码对象创建对象
            person2 = (Person) aClass3.newInstance();
            //通过反射获取属性，并赋值
//            Field age = aClass3.getDeclaredField("age");
//            age.setAccessible(true); //私有设置安全检查才能赋值
            Field studentID = aClass3.getDeclaredField("studentID");
            studentID.setAccessible(true);
            //age.set(person1, 100);
            studentID.set(person1, "gxdsbasdd");

            //取值
            //String n = (String) name.get(person1);
            //int a = (int) age.get(person1);
            String id = (String) studentID.get(person1);
            System.out.println(id);

            //调用方法
            Method[] declaredMethods = aClass3.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                Method declaredMethod = declaredMethods[i];
                System.out.println(declaredMethod.getName());
            }

            Method method1 = aClass3.getDeclaredMethod("study");
            String methodStr1 = (String) method1.invoke(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
