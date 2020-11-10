package com.iuoip.homework02.test3;

public interface Queue<T> {

    int size();

    boolean isEmpty();

    void insert(T element);

    T remoke();

    T peek();
}
