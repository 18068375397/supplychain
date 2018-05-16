package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkBuyOrderDetailDto;
import com.xinyonghang.supplychain.model.MkBuyOrderDetail;

import java.util.List;

public interface MkBuyOrderDetailMapper extends Mapper<MkBuyOrderDetail> {
    List<MkBuyOrderDetail> findList(MkBuyOrderDetailDto mkBuyOrderDetailDto);
}