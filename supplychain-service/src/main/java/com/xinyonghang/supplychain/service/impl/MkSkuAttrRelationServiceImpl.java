package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSkuAttrRelationMapper;
import com.xinyonghang.supplychain.model.MkSkuAttrRelation;
import com.xinyonghang.supplychain.dto.MkSkuAttrRelationDto;
import com.xinyonghang.supplychain.service.MkSkuAttrRelationService;
import com.xinyonghang.supplychain.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGeneratorTool on 2018/05/03.
 */
@Service
@Transactional
public class MkSkuAttrRelationServiceImpl implements MkSkuAttrRelationService {
    @Resource
    private MkSkuAttrRelationMapper mkSkuAttrRelationMapper;

    public void save(MkSkuAttrRelation mkSkuAttrRelation) {
        mkSkuAttrRelationMapper.insertSelective(mkSkuAttrRelation);
    }

    public void save(List<MkSkuAttrRelation> list) {
        mkSkuAttrRelationMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSkuAttrRelationMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSkuAttrRelationMapper.deleteByIds(ids);
    }

    public void update(MkSkuAttrRelation mkSkuAttrRelation) {
        mkSkuAttrRelationMapper.updateByPrimaryKeySelective(mkSkuAttrRelation);
    }

    public MkSkuAttrRelation findById(Long id) {
        return mkSkuAttrRelationMapper.selectByPrimaryKey(id);
    }

    public List<MkSkuAttrRelation> findByIds(String ids) {
        return mkSkuAttrRelationMapper.selectByIds(ids);
    }

    public List<MkSkuAttrRelation> findAll() {
        return mkSkuAttrRelationMapper.selectAll();
    }

    public PageInfo findList(MkSkuAttrRelationDto mkSkuAttrRelationDto) {
        PageHelper.startPage(mkSkuAttrRelationDto.getPage(), mkSkuAttrRelationDto.getSize());
        List<MkSkuAttrRelation> list = mkSkuAttrRelationMapper.findList(mkSkuAttrRelationDto);
        return new PageInfo(list);
    }


}
