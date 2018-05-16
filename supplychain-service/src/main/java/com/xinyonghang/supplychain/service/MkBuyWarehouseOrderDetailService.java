package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkBuyWarehouseOrderDetail;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDetailDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkBuyWarehouseOrderDetailService {
    void save(MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail);

    void save(List<MkBuyWarehouseOrderDetail> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail);

    MkBuyWarehouseOrderDetail findById(Long id);

    List<MkBuyWarehouseOrderDetail> findByIds(String ids);

    List<MkBuyWarehouseOrderDetail> findAll();//获取所有

    PageInfo findList(MkBuyWarehouseOrderDetailDto mkBuyWarehouseOrderDetailDto);
}
