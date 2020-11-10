package com.iuoip.homework04;

public class Attr {
    private String level;
    private int total;

    public Attr(String level) {
        this.total = 0;
        this.level = level;
    }

    public Attr(String level, int total) {
        this.level = level;
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                "level='" + level + '\'' +
                (total != 0 ? ", total=" + total : "") +
                '}';
    }
}
