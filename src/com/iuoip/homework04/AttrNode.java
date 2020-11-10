package com.iuoip.homework04;

/**
 * 属性节点类
 */
public class AttrNode extends Node {
    private Attr attr;

    public AttrNode(int id, String context, int pid, Attr attr) {
        super(id, context, pid);
        this.attr = attr;
    }

    public AttrNode(int id, String context, int pid) {
        super(id, context, pid);
    }

    public Attr getAttr() {
        return attr;
    }

    @Override
    public String toString() {
        return super.toString() +","+
                "attrbutes=" + attr.toString() +
                '}';
    }
}
