package com.iuoip.MemoryAllocation;

/**
 * 页表中的每一项
 */
public class PageTableItem {
    private int pageNo;  //页号
    private int blockNo; //块号

    public PageTableItem() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(int blockNo) {
        this.blockNo = blockNo;
    }

    @Override
    public String toString() {
        return " "+pageNo + "\t   " + blockNo;
    }
}
