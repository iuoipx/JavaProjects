package com.iuoip.homework01;

import java.util.Scanner;

public class Test03 {
    enum Type {toRight, toBottom, toLeft, toTop} //四种方向转向

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入n: ");
        int n = scanner.nextInt();

        int[][] res = new int[n][n];  //二维数组，保存排列之后的数据
        int i = 0;  //行下标
        int j = 0;  //列下标
        Type type = Type.toRight;

        for (int number = 1; number <= n * n; number++) {
            res[i][j] = number;
            if (type == Type.toRight) {
                j++;
                if (j == n || res[i][j] != 0) {  //到达列下标最大值时转向
                    type = Type.toBottom;
                    i++;
                    j--;
                }
            } else if (type == Type.toBottom) {
                i++;
                if (i == n || res[i][j] != 0) {  //到达行下标最大值时转向
                    type = Type.toLeft;
                    i--;
                    j--;
                }
            } else if (type == Type.toLeft) {
                j--;
                if (j == -1 || res[i][j] != 0) {
                    type = Type.toTop;
                    j++;
                    i--;
                }

            } else if (type == Type.toTop) {
                i--;
                if (i == 0 || res[i][j] != 0) {
                    type = Type.toRight;
                    i++;
                    j++;
                }
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(res[i][j] + "\t");
                if (j == n - 1) {
                    System.out.println(); //换行
                }
            }
        }
    }
}