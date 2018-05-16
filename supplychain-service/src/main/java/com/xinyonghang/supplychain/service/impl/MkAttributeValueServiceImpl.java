package com.xinyonghang.supplychain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.dao.MkAttributeValueMapper;
import com.xinyonghang.supplychain.dto.MkAttributeValueDto;
import com.xinyonghang.supplychain.model.MkAttributeValue;
import com.xinyonghang.supplychain.service.MkAttributeValueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGeneratorTool on 2018/04/18.
 */
@Service
@Transactional
public class MkAttributeValueServiceImpl implements MkAttributeValueService {
    @Resource
    private MkAttributeValueMapper mkAttributeValueMapper;

    public void save(MkAttributeValue mkAttributeValue) {
        mkAttributeValueMapper.insertSelective(mkAttributeValue);
    }

    public void save(List<MkAttributeValue> list) {
        mkAttributeValueMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkAttributeValueMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkAttributeValueMapper.deleteByIds(ids);
    }

    public void update(MkAttributeValue mkAttributeValue) {
        mkAttributeValueMapper.updateByPrimaryKeySelective(mkAttributeValue);
    }

    public MkAttributeValue findById(Long id) {
        return mkAttributeValueMapper.selectByPrimaryKey(id);
    }

    public List<MkAttributeValue> findByIds(String ids) {
        return mkAttributeValueMapper.selectByIds(ids);
    }

    public List<MkAttributeValue> findAll() {
        return mkAttributeValueMapper.selectAll();
    }

    @Override
    public PageInfo findList(MkAttributeValueDto mkAttributeValueDto) {
        PageHelper.startPage(mkAttributeValueDto.getPage(), mkAttributeValueDto.getSize());
        List<MkAttributeValue> list = mkAttributeValueMapper.findList(mkAttributeValueDto);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
