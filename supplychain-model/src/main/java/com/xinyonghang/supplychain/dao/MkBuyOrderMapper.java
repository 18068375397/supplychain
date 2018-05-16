package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkBuyOrderDto;
import com.xinyonghang.supplychain.model.MkBuyOrder;

import java.util.List;
import java.util.Map;

public interface MkBuyOrderMapper extends Mapper<MkBuyOrder> {
    List<MkBuyOrder> findList(MkBuyOrderDto mkBuyOrderDto);

    List<Map<String, Object>> findBuyOrderList(MkBuyOrderDto mkBuyOrderDto);
}