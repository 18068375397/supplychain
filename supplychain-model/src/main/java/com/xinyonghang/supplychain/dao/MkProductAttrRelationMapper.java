package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkProductAttrRelationDto;
import com.xinyonghang.supplychain.model.MkProductAttrRelation;

import java.util.List;

public interface MkProductAttrRelationMapper extends Mapper<MkProductAttrRelation> {
    List<MkProductAttrRelation> findList(MkProductAttrRelationDto mkProductAttrRelationDto);
}