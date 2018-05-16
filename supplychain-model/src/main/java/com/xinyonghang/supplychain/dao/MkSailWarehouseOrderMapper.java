package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDto;
import com.xinyonghang.supplychain.model.MkSailWarehouseOrder;

import java.util.List;

public interface MkSailWarehouseOrderMapper extends Mapper<MkSailWarehouseOrder> {
    List<MkSailWarehouseOrder> findList(MkSailWarehouseOrderDto mkSailWarehouseOrderDto);
}