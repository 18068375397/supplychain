package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkProductCategory;
import com.xinyonghang.supplychain.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGeneratorTool on 2018/04/19.
 */
public interface MkProductCategoryService {
    void save(MkProductCategory mkProductCategory);

    void save(List<MkProductCategory> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkProductCategory mkProductCategory);

    MkProductCategory findById(Long id);

    List<MkProductCategory> findByIds(String ids);

    List<MkProductCategory> findAll();//获取所有

    /**
     * 查询类目树
     *
     * @return
     */
    List<Map<String, Object>> findZtreeList();

    /**
     * 保存类目树
     *
     * @param ztreeJsonString
     */
    void saveZtreeList(String ztreeJsonString);

    /**
     * 按父节点查询类目
     *
     * @param parentId
     * @return
     */
    List<MkProductCategory> getCategoryByParentId(Long parentId);

}
