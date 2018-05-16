package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkBuyOrderDetail;
import com.xinyonghang.supplychain.dto.MkBuyOrderDetailDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkBuyOrderDetailService {
    void save(MkBuyOrderDetail mkBuyOrderDetail);

    void save(List<MkBuyOrderDetail> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkBuyOrderDetail mkBuyOrderDetail);

    MkBuyOrderDetail findById(Long id);

    List<MkBuyOrderDetail> findByIds(String ids);

    List<MkBuyOrderDetail> findAll();//获取所有

    PageInfo findList(MkBuyOrderDetailDto mkBuyOrderDetailDto);
}
