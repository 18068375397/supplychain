package com.xinyonghang.supplychain.service;

import com.github.pagehelper.PageInfo;

import com.xinyonghang.supplychain.dto.MkAttributeDto;
import com.xinyonghang.supplychain.model.MkAttribute;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGeneratorTool on 2018/04/20.
 */
public interface MkAttributeService {
    void save(MkAttribute mkAttribute);

    void save(List<MkAttribute> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkAttribute mkAttribute);

    MkAttribute findById(Long id);

    List<MkAttribute> findByIds(String ids);

    List<MkAttribute> findAll();//获取所有

    /**
     * 按条件查询属性
     *
     * @param mkAttributeDto
     * @return
     */
    PageInfo findList(MkAttributeDto mkAttributeDto);

    /**
     * 按类目categoryId 查询拓展属性
     *
     * @param categoryId
     * @return
     */
    List<MkAttribute> getAttributeListByCategoryId(Long categoryId);
}
