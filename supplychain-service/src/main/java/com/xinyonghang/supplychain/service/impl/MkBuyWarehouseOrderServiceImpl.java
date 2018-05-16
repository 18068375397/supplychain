package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkBuyWarehouseOrderMapper;
import com.xinyonghang.supplychain.model.MkBuyWarehouseOrder;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDto;
import com.xinyonghang.supplychain.service.MkBuyWarehouseOrderService;
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
public class MkBuyWarehouseOrderServiceImpl implements MkBuyWarehouseOrderService {
    @Resource
    private MkBuyWarehouseOrderMapper mkBuyWarehouseOrderMapper;

    public void save(MkBuyWarehouseOrder mkBuyWarehouseOrder) {
        mkBuyWarehouseOrderMapper.insertSelective(mkBuyWarehouseOrder);
    }

    public void save(List<MkBuyWarehouseOrder> list) {
        mkBuyWarehouseOrderMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkBuyWarehouseOrderMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkBuyWarehouseOrderMapper.deleteByIds(ids);
    }

    public void update(MkBuyWarehouseOrder mkBuyWarehouseOrder) {
        mkBuyWarehouseOrderMapper.updateByPrimaryKeySelective(mkBuyWarehouseOrder);
    }

    public MkBuyWarehouseOrder findById(Long id) {
        return mkBuyWarehouseOrderMapper.selectByPrimaryKey(id);
    }

    public List<MkBuyWarehouseOrder> findByIds(String ids) {
        return mkBuyWarehouseOrderMapper.selectByIds(ids);
    }

    public List<MkBuyWarehouseOrder> findAll() {
        return mkBuyWarehouseOrderMapper.selectAll();
    }

    public PageInfo findList(MkBuyWarehouseOrderDto mkBuyWarehouseOrderDto) {
        PageHelper.startPage(mkBuyWarehouseOrderDto.getPage(), mkBuyWarehouseOrderDto.getSize());
        List<MkBuyWarehouseOrder> list = mkBuyWarehouseOrderMapper.findList(mkBuyWarehouseOrderDto);
        return new PageInfo(list);
    }


}
