package com.iuoip.annotation;

@MyAnnotation(name = "gxsb", colleage = {"asd", "zxc"})
public class AnnotationTest {
    private String name;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        test1();
    }

    @Deprecated
    public static void test1() {
        System.out.println("Deprecated");
    }

    @MyAnnotation(name = "gxsb", colleage = {"asd", "zxc"})
    public static void test2() {

    }

    @Override
    public String toString() {
        return "AnnotationTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
