package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.core.Service;
import com.xinyonghang.supplychain.model.MkProductAttrRelation;

import java.util.List;


/**
 * Created by CodeGeneratorTool on 2018/04/13.
 */
public interface MkProductAttrRelationService {
    void save(MkProductAttrRelation mkProductAttrRelation);

    void save(List<MkProductAttrRelation> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkProductAttrRelation mkProductAttrRelation);

    MkProductAttrRelation findById(Long id);

    List<MkProductAttrRelation> findByIds(String ids);

    List<MkProductAttrRelation> findAll();//获取所有
}
