package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkSkuAttrRelation;
import com.xinyonghang.supplychain.dto.MkSkuAttrRelationDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/05/03.
 */
public interface MkSkuAttrRelationService {
    void save(MkSkuAttrRelation mkSkuAttrRelation);

    void save(List<MkSkuAttrRelation> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSkuAttrRelation mkSkuAttrRelation);

    MkSkuAttrRelation findById(Long id);

    List<MkSkuAttrRelation> findByIds(String ids);

    List<MkSkuAttrRelation> findAll();//获取所有

    PageInfo findList(MkSkuAttrRelationDto mkSkuAttrRelationDto);
}
