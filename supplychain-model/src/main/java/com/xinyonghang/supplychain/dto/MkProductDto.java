package com.xinyonghang.supplychain.dto;

import com.xinyonghang.supplychain.model.MkProduct;

import javax.validation.constraints.NotNull;

/**
 * Created by CodeGeneratorTool on 2018/04/28.
 */
public class MkProductDto extends MkProduct {
    @NotNull
    private Integer page;
    @NotNull
    private Integer size;

    private String sortColumn;

    private String sortOrder;

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

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
