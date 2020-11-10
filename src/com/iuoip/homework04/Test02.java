package com.iuoip.homework04;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<Node> attrNodes = new ArrayList<>();
        attrNodes.add(new AttrNode(1, "湖北师范大学", 0, new Attr("college")));
        attrNodes.add(new AttrNode(2, "计算机与信息学院", 1, new Attr("department")));
        attrNodes.add(new AttrNode(3, "1808班", 2, new Attr("class", 64)));
        attrNodes.add(new AttrNode(4, "1809班", 2, new Attr("class", 51)));
        attrNodes.add(new AttrNode(5, "1810班", 2, new Attr("class", 51)));
        attrNodes.add(new AttrNode(6, "1811班", 2, new Attr("class", 51)));

        Test01.printTreeData(attrNodes);
    }
}
