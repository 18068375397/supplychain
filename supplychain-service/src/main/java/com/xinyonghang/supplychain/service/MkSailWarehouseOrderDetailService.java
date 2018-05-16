package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkSailWarehouseOrderDetail;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDetailDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkSailWarehouseOrderDetailService {
    void save(MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail);

    void save(List<MkSailWarehouseOrderDetail> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail);

    MkSailWarehouseOrderDetail findById(Long id);

    List<MkSailWarehouseOrderDetail> findByIds(String ids);

    List<MkSailWarehouseOrderDetail> findAll();//获取所有

    PageInfo findList(MkSailWarehouseOrderDetailDto mkSailWarehouseOrderDetailDto);
}
