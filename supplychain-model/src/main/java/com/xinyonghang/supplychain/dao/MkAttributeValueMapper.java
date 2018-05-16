package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkAttributeValueDto;
import com.xinyonghang.supplychain.model.MkAttributeValue;

import java.util.List;

public interface MkAttributeValueMapper extends Mapper<MkAttributeValue> {

    /**
     * 按条件分页查询
     *
     * @param mkAttributeValueDto
     * @return
     */
    List<MkAttributeValue> findList(MkAttributeValueDto mkAttributeValueDto);
}