package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.core.AbstractService;
import com.xinyonghang.supplychain.dao.MkProductAttrRelationMapper;
import com.xinyonghang.supplychain.model.MkProductAttrRelation;
import com.xinyonghang.supplychain.service.MkProductAttrRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGeneratorTool on 2018/04/13.
 */
@Service
@Transactional
public class MkProductAttrRelationServiceImpl implements MkProductAttrRelationService {
    @Resource
    private MkProductAttrRelationMapper mkProductAttrRelationMapper;

    public void save(MkProductAttrRelation mkProductAttrRelation) {
        mkProductAttrRelationMapper.insertSelective(mkProductAttrRelation);
    }

    public void save(List<MkProductAttrRelation> list) {
        mkProductAttrRelationMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkProductAttrRelationMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkProductAttrRelationMapper.deleteByIds(ids);
    }

    public void update(MkProductAttrRelation mkProductAttrRelation) {
        mkProductAttrRelationMapper.updateByPrimaryKeySelective(mkProductAttrRelation);
    }

    public MkProductAttrRelation findById(Long id) {
        return mkProductAttrRelationMapper.selectByPrimaryKey(id);
    }

    public List<MkProductAttrRelation> findByIds(String ids) {
        return mkProductAttrRelationMapper.selectByIds(ids);
    }

    public List<MkProductAttrRelation> findAll() {
        return mkProductAttrRelationMapper.selectAll();
    }
}
