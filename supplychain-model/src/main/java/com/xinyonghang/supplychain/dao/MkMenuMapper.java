package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.dto.MkMenuDto;
import com.xinyonghang.supplychain.model.MkMenu;

import java.util.List;

public interface MkMenuMapper extends Mapper<MkMenu> {
    List<MkMenu> findList(MkMenuDto mkMenuDto);

    List<MkMenu> getMenuByParentId(Long parentId);
}