package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSkuAttrRelationDto;
import com.xinyonghang.supplychain.model.MkSkuAttrRelation;

import java.util.List;

public interface MkSkuAttrRelationMapper extends Mapper<MkSkuAttrRelation> {
    List<MkSkuAttrRelation> findList(MkSkuAttrRelationDto mkSkuAttrRelationDto);
}