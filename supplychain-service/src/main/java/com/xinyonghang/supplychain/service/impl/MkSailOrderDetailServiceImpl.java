package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSailOrderDetailMapper;
import com.xinyonghang.supplychain.model.MkSailOrderDetail;
import com.xinyonghang.supplychain.dto.MkSailOrderDetailDto;
import com.xinyonghang.supplychain.service.MkSailOrderDetailService;
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
public class MkSailOrderDetailServiceImpl implements MkSailOrderDetailService {
    @Resource
    private MkSailOrderDetailMapper mkSailOrderDetailMapper;

    public void save(MkSailOrderDetail mkSailOrderDetail) {
        mkSailOrderDetailMapper.insertSelective(mkSailOrderDetail);
    }

    public void save(List<MkSailOrderDetail> list) {
        mkSailOrderDetailMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSailOrderDetailMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSailOrderDetailMapper.deleteByIds(ids);
    }

    public void update(MkSailOrderDetail mkSailOrderDetail) {
        mkSailOrderDetailMapper.updateByPrimaryKeySelective(mkSailOrderDetail);
    }

    public MkSailOrderDetail findById(Long id) {
        return mkSailOrderDetailMapper.selectByPrimaryKey(id);
    }

    public List<MkSailOrderDetail> findByIds(String ids) {
        return mkSailOrderDetailMapper.selectByIds(ids);
    }

    public List<MkSailOrderDetail> findAll() {
        return mkSailOrderDetailMapper.selectAll();
    }

    public PageInfo findList(MkSailOrderDetailDto mkSailOrderDetailDto) {
        PageHelper.startPage(mkSailOrderDetailDto.getPage(), mkSailOrderDetailDto.getSize());
        List<MkSailOrderDetail> list = mkSailOrderDetailMapper.findList(mkSailOrderDetailDto);
        return new PageInfo(list);
    }


}
