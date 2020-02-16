package com.mydataway.utils;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PageQuery implements Serializable {
    @ApiModelProperty("页码")
    private Integer pageNum = Integer.valueOf(1);
    @ApiModelProperty("每页数量")
    private Integer pageSize = Integer.valueOf(10);

    public Integer getPageNum() {
        return this.pageNum == null ? 1 : Math.max(1, this.pageNum.intValue());
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize == null ? 10 : this.pageSize.intValue();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}