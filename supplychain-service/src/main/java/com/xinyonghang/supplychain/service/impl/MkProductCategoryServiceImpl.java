package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.core.AbstractService;
import com.xinyonghang.supplychain.dao.MkProductCategoryMapper;
import com.xinyonghang.supplychain.model.MkProductCategory;
import com.xinyonghang.supplychain.service.MkProductCategoryService;
import com.xinyonghang.supplychain.utils.GsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGeneratorTool on 2018/04/19.
 */
@Service
@Transactional
public class MkProductCategoryServiceImpl implements MkProductCategoryService {
    @Resource
    private MkProductCategoryMapper mkProductCategoryMapper;

    public void save(MkProductCategory mkProductCategory) {
        mkProductCategoryMapper.insertSelective(mkProductCategory);
    }

    public void save(List<MkProductCategory> list) {
        mkProductCategoryMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkProductCategoryMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkProductCategoryMapper.deleteByIds(ids);
    }

    public void update(MkProductCategory mkProductCategory) {
        mkProductCategoryMapper.updateByPrimaryKeySelective(mkProductCategory);
    }

    public MkProductCategory findById(Long id) {
        return mkProductCategoryMapper.selectByPrimaryKey(id);
    }

    public List<MkProductCategory> findByIds(String ids) {
        return mkProductCategoryMapper.selectByIds(ids);
    }

    public List<MkProductCategory> findAll() {
        return mkProductCategoryMapper.selectAll();
    }


    @Override
    public List<Map<String, Object>> findZtreeList() {
        return mkProductCategoryMapper.findZtreeList();
    }

    @Override
    public void saveZtreeList(String ztreeJsonString) {
        List<MkProductCategory> list = GsonUtil.jsonToList(ztreeJsonString, MkProductCategory.class);
//        for (MkProductCategory mkProductCategory : list) {
//            System.out.println(mkProductCategory.getId());
//        }
        // 先删除树
        Condition c = new Condition(MkProductCategory.class);
        c.createCriteria().andCondition("id > 0");
        mkProductCategoryMapper.deleteByCondition(c);
        // 重新保存树
        mkProductCategoryMapper.insertList(list);
    }

    @Override
    public List<MkProductCategory> getCategoryByParentId(Long parentId) {
        List<MkProductCategory> list = mkProductCategoryMapper.selectCategoryByParentId(parentId);
        return list;
    }
}
