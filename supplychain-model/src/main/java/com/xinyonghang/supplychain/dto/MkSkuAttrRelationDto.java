package com.xinyonghang.supplychain.dto;

import com.xinyonghang.supplychain.model.MkSkuAttrRelation;

import javax.validation.constraints.NotNull;

/**
 * Created by CodeGeneratorTool on 2018/05/03.
 */
public class MkSkuAttrRelationDto extends MkSkuAttrRelation {
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
