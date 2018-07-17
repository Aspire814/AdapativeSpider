package com.storm.common;

import java.util.List;

/**
 * 分页
 * @author 李斯
 * @date 2018年7月16日 下午5:11:47 
 * @version V1.0
 */
public class Page<T> {
    /**
     * 页序号（以零开始）
     */
    private int pageIndex;
    
    /**
     * 每页记录数
     */
    private int pageSize;
    
    /**
     * 页数
     */
    private int pageCount;

    /**
     * 总共记录数
     */
    private int total;
    
    /**
     * 起始记录下标
     */
    private int startRow = 0;
    
    /**
     * 数据列表
     */
    private List<T> datas;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
    
}
