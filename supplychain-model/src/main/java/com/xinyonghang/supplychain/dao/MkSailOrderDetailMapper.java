package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSailOrderDetailDto;
import com.xinyonghang.supplychain.model.MkSailOrderDetail;

import java.util.List;

public interface MkSailOrderDetailMapper extends Mapper<MkSailOrderDetail> {
    List<MkSailOrderDetail> findList(MkSailOrderDetailDto mkSailOrderDetailDto);
}