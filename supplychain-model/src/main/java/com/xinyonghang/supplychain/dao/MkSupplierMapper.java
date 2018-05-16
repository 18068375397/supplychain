package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkSupplierDto;
import com.xinyonghang.supplychain.model.MkSupplier;

import java.util.List;

public interface MkSupplierMapper extends Mapper<MkSupplier> {
    List<MkSupplier> findList(MkSupplierDto mkSupplierDto);
}