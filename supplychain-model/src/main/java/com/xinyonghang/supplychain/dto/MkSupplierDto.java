package com.xinyonghang.supplychain.dto;

import com.xinyonghang.supplychain.model.MkSupplier;

import javax.validation.constraints.NotNull;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public class MkSupplierDto extends MkSupplier {
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
