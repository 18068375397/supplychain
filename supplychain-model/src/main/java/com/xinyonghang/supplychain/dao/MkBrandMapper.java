package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkBrandDto;
import com.xinyonghang.supplychain.model.MkBrand;

import java.util.List;
import java.util.Map;

public interface MkBrandMapper extends Mapper<MkBrand> {
    List<Map<String, Object>> findList(MkBrandDto mkBrandDto);

    List<Map<String, Object>> findBrandList(MkBrandDto mkBrandDto);
}