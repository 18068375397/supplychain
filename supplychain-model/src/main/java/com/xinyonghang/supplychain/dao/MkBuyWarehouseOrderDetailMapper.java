package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDetailDto;
import com.xinyonghang.supplychain.model.MkBuyWarehouseOrderDetail;

import java.util.List;

public interface MkBuyWarehouseOrderDetailMapper extends Mapper<MkBuyWarehouseOrderDetail> {
    List<MkBuyWarehouseOrderDetail> findList(MkBuyWarehouseOrderDetailDto mkBuyWarehouseOrderDetailDto);
}