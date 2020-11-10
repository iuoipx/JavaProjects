package com.iuoip.homework04;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {

        //初始化数据
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1, "湖北师范大学", 0));
        nodes.add(new Node(2, "计算机与信息学院", 1));
        nodes.add(new Node(3, "1808班", 2));
        nodes.add(new Node(4, "1809班", 2));
        nodes.add(new Node(5, "1810班", 2));
        nodes.add(new Node(6, "1811班", 2));

        printTreeData(nodes);

    }

    /**
     * 输出树形数据函数
     * @param nodes List数据参数
     */
    public static void printTreeData(List<Node> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            List<Node> children = new ArrayList<>();
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(i).getId() == nodes.get(j).getPid()) {
                    children.add(nodes.get(j));
                }
            }
            nodes.get(i).setChildren(children);
        }
        //输出list集合第一个元素
        System.out.println(nodes.get(0).toString());
    }
}
