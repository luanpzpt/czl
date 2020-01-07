package com.library.entity;

import java.util.List;

public class Page<T> {
    private int pageSize;   //页面长度
    private int currentPage; //当前页面
    private int totalCount;  //页面总数
    private int totalPage;  //总页数
    private List<Object> list;

    public Page() {

    }

    public Page(int pageSize, int totalCount, List<Object> list) {

        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }


    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
