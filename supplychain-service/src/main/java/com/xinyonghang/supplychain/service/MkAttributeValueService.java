package com.xinyonghang.supplychain.service;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Service;
import com.xinyonghang.supplychain.dto.MkAttributeValueDto;
import com.xinyonghang.supplychain.model.MkAttributeValue;

import java.util.List;


/**
 * Created by CodeGeneratorTool on 2018/04/18.
 */
public interface MkAttributeValueService {
    void save(MkAttributeValue mkAttributeValue);

    void save(List<MkAttributeValue> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkAttributeValue mkAttributeValue);

    MkAttributeValue findById(Long id);

    List<MkAttributeValue> findByIds(String ids);

    List<MkAttributeValue> findAll();

    /**
     * 根据AttrId 分页查询
     *
     * @return
     */
    PageInfo findList(MkAttributeValueDto mkAttributeValueDto);
}
