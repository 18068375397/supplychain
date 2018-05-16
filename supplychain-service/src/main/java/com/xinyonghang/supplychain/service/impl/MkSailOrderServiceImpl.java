package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSailOrderMapper;
import com.xinyonghang.supplychain.model.MkSailOrder;
import com.xinyonghang.supplychain.dto.MkSailOrderDto;
import com.xinyonghang.supplychain.service.MkSailOrderService;
import com.xinyonghang.supplychain.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@Service
@Transactional
public class MkSailOrderServiceImpl implements MkSailOrderService {
    @Resource
    private MkSailOrderMapper mkSailOrderMapper;

    public void save(MkSailOrder mkSailOrder) {
        mkSailOrderMapper.insertSelective(mkSailOrder);
    }

    public void save(List<MkSailOrder> list) {
        mkSailOrderMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSailOrderMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSailOrderMapper.deleteByIds(ids);
    }

    public void update(MkSailOrder mkSailOrder) {
        mkSailOrderMapper.updateByPrimaryKeySelective(mkSailOrder);
    }

    public MkSailOrder findById(Long id) {
        return mkSailOrderMapper.selectByPrimaryKey(id);
    }

    public List<MkSailOrder> findByIds(String ids) {
        return mkSailOrderMapper.selectByIds(ids);
    }

    public List<MkSailOrder> findAll() {
        return mkSailOrderMapper.selectAll();
    }

    public PageInfo findList(MkSailOrderDto mkSailOrderDto) {
        PageHelper.startPage(mkSailOrderDto.getPage(), mkSailOrderDto.getSize());
        List<MkSailOrder> list = mkSailOrderMapper.findList(mkSailOrderDto);
        return new PageInfo(list);
    }


}
