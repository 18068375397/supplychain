package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSkuAttributeDto;
import com.xinyonghang.supplychain.model.MkSkuAttribute;

import java.util.List;
import java.util.Map;

public interface MkSkuAttributeMapper extends Mapper<MkSkuAttribute> {
    List<MkSkuAttribute> findList(MkSkuAttributeDto mkSkuAttributeDto);

    List<Map<String, Object>> findSkuList(MkSkuAttributeDto mkSkuAttributeDto);
}