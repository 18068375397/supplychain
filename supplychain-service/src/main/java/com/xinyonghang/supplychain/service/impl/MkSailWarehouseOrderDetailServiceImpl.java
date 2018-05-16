package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSailWarehouseOrderDetailMapper;
import com.xinyonghang.supplychain.model.MkSailWarehouseOrderDetail;
import com.xinyonghang.supplychain.dto.MkSailWarehouseOrderDetailDto;
import com.xinyonghang.supplychain.service.MkSailWarehouseOrderDetailService;
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
public class MkSailWarehouseOrderDetailServiceImpl implements MkSailWarehouseOrderDetailService {
    @Resource
    private MkSailWarehouseOrderDetailMapper mkSailWarehouseOrderDetailMapper;

    public void save(MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail) {
        mkSailWarehouseOrderDetailMapper.insertSelective(mkSailWarehouseOrderDetail);
    }

    public void save(List<MkSailWarehouseOrderDetail> list) {
        mkSailWarehouseOrderDetailMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSailWarehouseOrderDetailMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSailWarehouseOrderDetailMapper.deleteByIds(ids);
    }

    public void update(MkSailWarehouseOrderDetail mkSailWarehouseOrderDetail) {
        mkSailWarehouseOrderDetailMapper.updateByPrimaryKeySelective(mkSailWarehouseOrderDetail);
    }

    public MkSailWarehouseOrderDetail findById(Long id) {
        return mkSailWarehouseOrderDetailMapper.selectByPrimaryKey(id);
    }

    public List<MkSailWarehouseOrderDetail> findByIds(String ids) {
        return mkSailWarehouseOrderDetailMapper.selectByIds(ids);
    }

    public List<MkSailWarehouseOrderDetail> findAll() {
        return mkSailWarehouseOrderDetailMapper.selectAll();
    }

    public PageInfo findList(MkSailWarehouseOrderDetailDto mkSailWarehouseOrderDetailDto) {
        PageHelper.startPage(mkSailWarehouseOrderDetailDto.getPage(), mkSailWarehouseOrderDetailDto.getSize());
        List<MkSailWarehouseOrderDetail> list = mkSailWarehouseOrderDetailMapper.findList(mkSailWarehouseOrderDetailDto);
        return new PageInfo(list);
    }


}
