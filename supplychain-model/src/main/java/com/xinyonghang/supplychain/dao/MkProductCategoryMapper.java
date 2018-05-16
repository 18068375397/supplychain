package com.xinyonghang.supplychain.dao;

import com.xinyonghang.supplychain.core.Mapper;
import com.xinyonghang.supplychain.model.MkProductCategory;

import java.util.List;
import java.util.Map;

public interface MkProductCategoryMapper extends Mapper<MkProductCategory> {
    List<Map<String, Object>> findZtreeList();

    /**
     * 查询指定父类下的类目
     *
     * @param parentId
     * @return
     */
    List<MkProductCategory> selectCategoryByParentId(Long parentId);

}