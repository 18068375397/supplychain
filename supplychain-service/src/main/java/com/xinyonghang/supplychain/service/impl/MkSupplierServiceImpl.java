package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSupplierMapper;
import com.xinyonghang.supplychain.model.MkSupplier;
import com.xinyonghang.supplychain.dto.MkSupplierDto;
import com.xinyonghang.supplychain.service.MkSupplierService;
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
public class MkSupplierServiceImpl implements MkSupplierService {
    @Resource
    private MkSupplierMapper mkSupplierMapper;

    public void save(MkSupplier mkSupplier) {
        mkSupplierMapper.insertSelective(mkSupplier);
    }

    public void save(List<MkSupplier> list) {
        mkSupplierMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSupplierMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSupplierMapper.deleteByIds(ids);
    }

    public void update(MkSupplier mkSupplier) {
        mkSupplierMapper.updateByPrimaryKeySelective(mkSupplier);
    }

    public MkSupplier findById(Long id) {
        return mkSupplierMapper.selectByPrimaryKey(id);
    }

    public List<MkSupplier> findByIds(String ids) {
        return mkSupplierMapper.selectByIds(ids);
    }

    public List<MkSupplier> findAll() {
        return mkSupplierMapper.selectAll();
    }

    public PageInfo findList(MkSupplierDto mkSupplierDto) {
        PageHelper.startPage(mkSupplierDto.getPage(), mkSupplierDto.getSize());
        List<MkSupplier> list = mkSupplierMapper.findList(mkSupplierDto);
        return new PageInfo(list);
    }


}
