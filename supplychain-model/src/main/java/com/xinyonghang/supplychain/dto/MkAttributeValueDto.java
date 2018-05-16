package com.xinyonghang.supplychain.dto;

import com.xinyonghang.supplychain.model.MkAttributeValue;

import javax.validation.constraints.NotNull;

public class MkAttributeValueDto extends MkAttributeValue {
    @NotNull
    private Integer page;
    @NotNull
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}