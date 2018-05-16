package com.xinyonghang.supplychain.dto;

import com.xinyonghang.supplychain.model.MkWarehouse;

import javax.validation.constraints.NotNull;

/**
 * Created by CodeGeneratorTool on 2018/05/07.
 */
public class MkWarehouseDto extends MkWarehouse {
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
