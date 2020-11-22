package com.iuoip.MemoryAllocation;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private final static int BlockNum = 64; //块总数
    private final static int ByteNo = (int) Math.sqrt(BlockNum); //字节数
    private final static int WorkPageCount = 5;   //分配作业页数

    public static void main(String[] args) {
        //初始化位示图
        int[][] bitmap = initBitmap();
        //打印位示图
        System.out.println("初始情况的位示图：");
        showBitmap(bitmap);

        int[] blockNoArr = new int[WorkPageCount];
        int num = 0;
        for (int j = 0; j < ByteNo; j++) {
            for (int i = 0; i < ByteNo; i++) {
                if (bitmap[j][i] == 0) {
                    int blockNo = j * 8 + i;
                    blockNoArr[num++] = blockNo;
                    //分配空间后置为1
                    bitmap[j][i] = 1;
                    if (num >= WorkPageCount) {
                        break;
                    }
                }
            }
            if (num >= WorkPageCount) {
                break;
            }
        }
        System.out.println(">>>开始分配作业......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("分配作业后的位示图：");
        showBitmap(bitmap);

        List<PageTableItem> pageTable = createPageTable(blockNoArr);
        System.out.println("为作业建立的页表：");
        System.out.println("页号  块号");
        for (PageTableItem pageTableItem : pageTable)
            System.out.println(pageTableItem.toString());


        System.out.println(">>>开始回收作业......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //已经完成的作业所占用的块号数组
        int[] workFinish = {4, 5, 6, 31};
        for (int blockNo : workFinish) {
            int byteNo = blockNo / ByteNo;
            int bitNo = blockNo % ByteNo;
            bitmap[byteNo][bitNo] = 0;
        }
        System.out.println("回收作业后的位示图：");
        showBitmap(bitmap);
    }

    /**
     * 初始化二维位示图
     *
     * @return 初始后的二维位示图
     */
    private static int[][] initBitmap() {
        //定义并初始化位示图
        int[][] tempBitmap = new int[ByteNo][ByteNo];
        for (int j = 0; j < ByteNo; j++) {
            for (int i = 0; i < ByteNo; i++) {
                tempBitmap[j][i] = 0;
                switch (j * 8 + i) {
                    case 0:
                        tempBitmap[j][i] = 1;
                    case 1:
                        tempBitmap[j][i] = 1;
                    case 4:
                        tempBitmap[j][i] = 1;
                    case 5:
                        tempBitmap[j][i] = 1;
                    case 6:
                        tempBitmap[j][i] = 1;
                    case 9:
                        tempBitmap[j][i] = 1;
                    case 11:
                        tempBitmap[j][i] = 1;
                    case 13:
                        tempBitmap[j][i] = 1;
                    case 24:
                        tempBitmap[j][i] = 1;
                    case 31:
                        tempBitmap[j][i] = 1;
                }
            }
        }
        return tempBitmap;
    }

    /**
     * 按格式输出打印二维位示图
     *
     * @param tempBitmap 位示图二维数组
     */
    private static void showBitmap(int[][] tempBitmap) {
        int blockCount = 0;
        System.out.print("字节号\\位数\t");
        for (int i = 0; i < ByteNo; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int j = 0; j < ByteNo; j++) {
            System.out.print("\t" + j + "\t\t");
            for (int i = 0; i < ByteNo; i++) {
                System.out.print(tempBitmap[j][i] + "\t");
                if (tempBitmap[j][i] == 0) {
                    blockCount++;
                }
                if (i % 7 == 0 && i != 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("当前空闲块数：" + blockCount);
    }

    /**
     * 创建页表函数
     *
     * @param blockNo 包含作业页号对应块号的数组
     * @return
     */
    public static List<PageTableItem> createPageTable(int[] blockNo) {
        List<PageTableItem> pageTable = new ArrayList<PageTableItem>();
        for (int i = 0; i < blockNo.length; i++) {
            PageTableItem pageTableItem = new PageTableItem();
            pageTableItem.setPageNo(i);
            pageTableItem.setBlockNo(blockNo[i]);
            pageTable.add(pageTableItem);
        }
        return pageTable;
    }
}
