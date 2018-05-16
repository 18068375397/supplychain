package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSailWarehouseOrderMapper;
import com.xinyonghang.supplychain.model.MkSailWarehouseOrder;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDto;
import com.xinyonghang.supplychain.service.MkSailWarehouseOrderService;
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
public class MkSailWarehouseOrderServiceImpl implements MkSailWarehouseOrderService {
    @Resource
    private MkSailWarehouseOrderMapper mkSailWarehouseOrderMapper;

    public void save(MkSailWarehouseOrder mkSailWarehouseOrder) {
        mkSailWarehouseOrderMapper.insertSelective(mkSailWarehouseOrder);
    }

    public void save(List<MkSailWarehouseOrder> list) {
        mkSailWarehouseOrderMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSailWarehouseOrderMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSailWarehouseOrderMapper.deleteByIds(ids);
    }

    public void update(MkSailWarehouseOrder mkSailWarehouseOrder) {
        mkSailWarehouseOrderMapper.updateByPrimaryKeySelective(mkSailWarehouseOrder);
    }

    public MkSailWarehouseOrder findById(Long id) {
        return mkSailWarehouseOrderMapper.selectByPrimaryKey(id);
    }

    public List<MkSailWarehouseOrder> findByIds(String ids) {
        return mkSailWarehouseOrderMapper.selectByIds(ids);
    }

    public List<MkSailWarehouseOrder> findAll() {
        return mkSailWarehouseOrderMapper.selectAll();
    }

    public PageInfo findList(MkSailWarehouseOrderDto mkSailWarehouseOrderDto) {
        PageHelper.startPage(mkSailWarehouseOrderDto.getPage(), mkSailWarehouseOrderDto.getSize());
        List<MkSailWarehouseOrder> list = mkSailWarehouseOrderMapper.findList(mkSailWarehouseOrderDto);
        return new PageInfo(list);
    }


}
