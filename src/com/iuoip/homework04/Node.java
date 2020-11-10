package com.iuoip.homework04;

import java.util.List;

/**
 * 节点类
 */
public class Node {
    private int id;
    private String context;
    private int pid;
    private List<Node> children;

    public Node(int id, String context, int pid) {
        this.id = id;
        this.context = context;
        this.pid = pid;
    }

    public String getContext() {
        return context;
    }

    public int getId() {
        return id;
    }


    public int getPid() {
        return pid;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "context='" + context + '\'' +
                ", id=" + id +
                ", pid=" + pid +
                ", children=" + (children == null ? "[]" : children) +
                "}";
    }
}
