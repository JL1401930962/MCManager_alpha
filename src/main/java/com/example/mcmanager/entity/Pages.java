package com.example.mcmanager.entity;


import lombok.Data;

import java.util.List;

@Data
public class Pages<T> {
    /**
     * 每页显示条数
     */
    private Integer pageSize;
    /**
     * 共多少页
     */
    private Integer totalPage;
    /**
     * 共多少条数据
     */
    private Integer totalRecord;
    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 数据
     */
    private List<T> data;



    public Pages() {

    }

    public Pages(Integer pageSize, Integer totalPage, Integer totalRecord, Integer pageIndex, List<T> data) {
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.pageIndex = pageIndex;
        this.data = data;
    }
}
