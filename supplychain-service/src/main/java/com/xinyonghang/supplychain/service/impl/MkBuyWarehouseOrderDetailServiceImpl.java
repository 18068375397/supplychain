package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkBuyWarehouseOrderDetailMapper;
import com.xinyonghang.supplychain.model.MkBuyWarehouseOrderDetail;
import com.xinyonghang.supplychain.dto.MkBuyWarehouseOrderDetailDto;
import com.xinyonghang.supplychain.service.MkBuyWarehouseOrderDetailService;
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
public class MkBuyWarehouseOrderDetailServiceImpl implements MkBuyWarehouseOrderDetailService {
    @Resource
    private MkBuyWarehouseOrderDetailMapper mkBuyWarehouseOrderDetailMapper;

    public void save(MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail) {
        mkBuyWarehouseOrderDetailMapper.insertSelective(mkBuyWarehouseOrderDetail);
    }

    public void save(List<MkBuyWarehouseOrderDetail> list) {
        mkBuyWarehouseOrderDetailMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkBuyWarehouseOrderDetailMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkBuyWarehouseOrderDetailMapper.deleteByIds(ids);
    }

    public void update(MkBuyWarehouseOrderDetail mkBuyWarehouseOrderDetail) {
        mkBuyWarehouseOrderDetailMapper.updateByPrimaryKeySelective(mkBuyWarehouseOrderDetail);
    }

    public MkBuyWarehouseOrderDetail findById(Long id) {
        return mkBuyWarehouseOrderDetailMapper.selectByPrimaryKey(id);
    }

    public List<MkBuyWarehouseOrderDetail> findByIds(String ids) {
        return mkBuyWarehouseOrderDetailMapper.selectByIds(ids);
    }

    public List<MkBuyWarehouseOrderDetail> findAll() {
        return mkBuyWarehouseOrderDetailMapper.selectAll();
    }

    public PageInfo findList(MkBuyWarehouseOrderDetailDto mkBuyWarehouseOrderDetailDto) {
        PageHelper.startPage(mkBuyWarehouseOrderDetailDto.getPage(), mkBuyWarehouseOrderDetailDto.getSize());
        List<MkBuyWarehouseOrderDetail> list = mkBuyWarehouseOrderDetailMapper.findList(mkBuyWarehouseOrderDetailDto);
        return new PageInfo(list);
    }


}
