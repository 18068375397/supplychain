package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkSailWarehouseOrder;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkSailWarehouseOrderService {
    void save(MkSailWarehouseOrder mkSailWarehouseOrder);

    void save(List<MkSailWarehouseOrder> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSailWarehouseOrder mkSailWarehouseOrder);

    MkSailWarehouseOrder findById(Long id);

    List<MkSailWarehouseOrder> findByIds(String ids);

    List<MkSailWarehouseOrder> findAll();//获取所有

    PageInfo findList(MkSailWarehouseOrderDto mkSailWarehouseOrderDto);
}
