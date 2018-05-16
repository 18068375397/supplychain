package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDetailDto;
import com.xinyonghang.supplychain.model.MkSailWarehouseOrderDetail;

import java.util.List;

public interface MkSailWarehouseOrderDetailMapper extends Mapper<MkSailWarehouseOrderDetail> {
    List<MkSailWarehouseOrderDetail> findList(MkSailWarehouseOrderDetailDto mkSailWarehouseOrderDetailDto);
}