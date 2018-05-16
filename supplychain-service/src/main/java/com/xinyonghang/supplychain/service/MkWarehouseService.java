package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkWarehouse;
import com.xinyonghang.supplychain.dto.MkWarehouseDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/05/07.
 */
public interface MkWarehouseService {
    void save(MkWarehouse mkWarehouse);

    void save(List<MkWarehouse> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkWarehouse mkWarehouse);

    MkWarehouse findById(Long id);

    List<MkWarehouse> findByIds(String ids);

    List<MkWarehouse> findAll();//获取所有

    PageInfo findList(MkWarehouseDto mkWarehouseDto);
}
