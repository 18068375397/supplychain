package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkBuyOrderDetailMapper;
import com.xinyonghang.supplychain.model.MkBuyOrderDetail;
import com.xinyonghang.supplychain.dto.MkBuyOrderDetailDto;
import com.xinyonghang.supplychain.service.MkBuyOrderDetailService;
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
public class MkBuyOrderDetailServiceImpl implements MkBuyOrderDetailService {
    @Resource
    private MkBuyOrderDetailMapper mkBuyOrderDetailMapper;

    public void save(MkBuyOrderDetail mkBuyOrderDetail) {
        mkBuyOrderDetailMapper.insertSelective(mkBuyOrderDetail);
    }

    public void save(List<MkBuyOrderDetail> list) {
        mkBuyOrderDetailMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkBuyOrderDetailMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkBuyOrderDetailMapper.deleteByIds(ids);
    }

    public void update(MkBuyOrderDetail mkBuyOrderDetail) {
        mkBuyOrderDetailMapper.updateByPrimaryKeySelective(mkBuyOrderDetail);
    }

    public MkBuyOrderDetail findById(Long id) {
        return mkBuyOrderDetailMapper.selectByPrimaryKey(id);
    }

    public List<MkBuyOrderDetail> findByIds(String ids) {
        return mkBuyOrderDetailMapper.selectByIds(ids);
    }

    public List<MkBuyOrderDetail> findAll() {
        return mkBuyOrderDetailMapper.selectAll();
    }

    public PageInfo findList(MkBuyOrderDetailDto mkBuyOrderDetailDto) {
        PageHelper.startPage(mkBuyOrderDetailDto.getPage(), mkBuyOrderDetailDto.getSize());
        List<MkBuyOrderDetail> list = mkBuyOrderDetailMapper.findList(mkBuyOrderDetailDto);
        return new PageInfo(list);
    }


}
