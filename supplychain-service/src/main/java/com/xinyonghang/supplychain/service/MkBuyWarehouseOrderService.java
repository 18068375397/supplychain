package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkBuyWarehouseOrder;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkBuyWarehouseOrderService {
    void save(MkBuyWarehouseOrder mkBuyWarehouseOrder);

    void save(List<MkBuyWarehouseOrder> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkBuyWarehouseOrder mkBuyWarehouseOrder);

    MkBuyWarehouseOrder findById(Long id);

    List<MkBuyWarehouseOrder> findByIds(String ids);

    List<MkBuyWarehouseOrder> findAll();//获取所有

    PageInfo findList(MkBuyWarehouseOrderDto mkBuyWarehouseOrderDto);
}
