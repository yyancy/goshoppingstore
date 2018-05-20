package com.store.dto;

public class Page {
    private Integer allRecord; //总记录数
    private Integer curpage;  //当前页码
    private Integer pageSize; //每页显示的记录数
    private Integer totalPages; //总页码

    public Page(Integer curpage, Integer pageSize) {
        this.curpage = curpage;
        this.pageSize = pageSize;
    }

    public Integer getAllRecord() {
        return allRecord;
    }

    public void setAllRecord(Integer allRecord) {
        this.allRecord = allRecord;
    }

    public Integer getCurpage() {
        return curpage;
    }

    public void setCurpage(Integer curpage) {
        this.curpage = curpage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        Integer pages = allRecord % pageSize;
        return pages == 0 ? allRecord / pageSize : allRecord / pageSize + 1;
    }


}
