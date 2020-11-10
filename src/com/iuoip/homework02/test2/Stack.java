package com.iuoip.homework02.test2;

public interface Stack<T> {

    int size();

    boolean isEmpty();

    void push(T element);

    T pop();

    T peek();
}
