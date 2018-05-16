package com.xinyonghang.supplychain.dao;

import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkProductDto;
import com.xinyonghang.supplychain.model.MkProduct;

import java.util.List;
import java.util.Map;

public interface MkProductMapper extends Mapper<MkProduct> {
    List<MkProduct> findList(MkProductDto mkProductDto);

    List<Map<String, Object>> findProductList(MkProductDto mkProductDto);

}