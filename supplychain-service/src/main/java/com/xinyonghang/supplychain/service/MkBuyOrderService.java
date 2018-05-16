package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkBuyOrder;
import com.xinyonghang.supplychain.dto.MkBuyOrderDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkBuyOrderService {
    void save(MkBuyOrder mkBuyOrder);

    void save(List<MkBuyOrder> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkBuyOrder mkBuyOrder);

    MkBuyOrder findById(Long id);

    List<MkBuyOrder> findByIds(String ids);

    List<MkBuyOrder> findAll();//获取所有

    PageInfo findList(MkBuyOrderDto mkBuyOrderDto);
}
