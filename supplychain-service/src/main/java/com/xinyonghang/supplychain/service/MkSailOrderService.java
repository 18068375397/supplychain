package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkSailOrder;
import com.xinyonghang.supplychain.dto.MkSailOrderDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkSailOrderService {
    void save(MkSailOrder mkSailOrder);

    void save(List<MkSailOrder> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSailOrder mkSailOrder);

    MkSailOrder findById(Long id);

    List<MkSailOrder> findByIds(String ids);

    List<MkSailOrder> findAll();//获取所有

    PageInfo findList(MkSailOrderDto mkSailOrderDto);
}
