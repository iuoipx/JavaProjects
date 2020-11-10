package com.iuoip.collection;

public class Generic {
    private Object[] element;

    public Generic(int capacity) {
        this.element = new Object[capacity];
    }

    public void addData(int index, Object data) {
        element[index] = data;
    }

    public Object getData(int index) {
        return element[index];
    }
}
