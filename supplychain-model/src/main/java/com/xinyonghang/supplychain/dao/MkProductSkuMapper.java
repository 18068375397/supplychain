package com.xinyonghang.supplychain.dao;

import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkProductSkuDto;
import com.xinyonghang.supplychain.model.MkProductSku;

import java.util.List;
import java.util.Map;

public interface MkProductSkuMapper extends Mapper<MkProductSku> {
    List<MkProductSku> findList(MkProductSkuDto mkProductSkuDto);


    /**
     * 按品牌,类目 查询商品SKU列表(采购挑选)
     *
     * @return
     */
    List<Map<String, Object>> getProductSkuList(Map<String, Object> params);
}