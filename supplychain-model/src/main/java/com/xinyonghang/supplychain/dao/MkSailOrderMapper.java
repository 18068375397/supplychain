package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSailOrderDto;
import com.xinyonghang.supplychain.model.MkSailOrder;

import java.util.List;

public interface MkSailOrderMapper extends Mapper<MkSailOrder> {
    List<MkSailOrder> findList(MkSailOrderDto mkSailOrderDto);
}