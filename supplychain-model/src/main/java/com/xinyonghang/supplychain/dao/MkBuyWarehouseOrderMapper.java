package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDto;
import com.xinyonghang.supplychain.model.MkBuyWarehouseOrder;

import java.util.List;

public interface MkBuyWarehouseOrderMapper extends Mapper<MkBuyWarehouseOrder> {
    List<MkBuyWarehouseOrder> findList(MkBuyWarehouseOrderDto mkBuyWarehouseOrderDto);
}