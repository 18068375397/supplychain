package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkWarehouseDto;
import com.xinyonghang.supplychain.model.MkWarehouse;

import java.util.List;
import java.util.Map;

public interface MkWarehouseMapper extends Mapper<MkWarehouse> {
    List<MkWarehouse> findList(MkWarehouseDto mkWarehouseDto);

    List<Map<String, Object>> findWarehouseList(MkWarehouseDto mkWarehouseDto);
}