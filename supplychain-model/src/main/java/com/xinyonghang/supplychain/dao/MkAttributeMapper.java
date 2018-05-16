package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkAttributeDto;
import com.xinyonghang.supplychain.model.MkAttribute;

import java.util.List;
import java.util.Map;

public interface MkAttributeMapper extends Mapper<MkAttribute> {
    /**
     * 按条件查询属性
     *
     * @return
     */
    List<MkAttribute> findList(MkAttributeDto mkAttributeDto);

    List<Map<String, Object>> findAttList(MkAttributeDto mkAttributeDto);

}