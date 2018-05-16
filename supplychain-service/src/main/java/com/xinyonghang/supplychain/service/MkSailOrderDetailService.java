package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkSailOrderDetail;
import com.xinyonghang.supplychain.dto.MkSailOrderDetailDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkSailOrderDetailService {
    void save(MkSailOrderDetail mkSailOrderDetail);

    void save(List<MkSailOrderDetail> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSailOrderDetail mkSailOrderDetail);

    MkSailOrderDetail findById(Long id);

    List<MkSailOrderDetail> findByIds(String ids);

    List<MkSailOrderDetail> findAll();//获取所有

    PageInfo findList(MkSailOrderDetailDto mkSailOrderDetailDto);
}
