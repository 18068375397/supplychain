package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkWarehouseMapper;
import com.xinyonghang.supplychain.model.MkWarehouse;
import com.xinyonghang.supplychain.dto.MkWarehouseDto;
import com.xinyonghang.supplychain.service.MkWarehouseService;
import com.xinyonghang.supplychain.core.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGeneratorTool on 2018/05/07.
 */
@Service
@Transactional
public class MkWarehouseServiceImpl implements MkWarehouseService {
    @Resource
    private MkWarehouseMapper mkWarehouseMapper;

    public void save(MkWarehouse mkWarehouse) {
        mkWarehouseMapper.insertSelective(mkWarehouse);
    }

    public void save(List<MkWarehouse> list) {
        mkWarehouseMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkWarehouseMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkWarehouseMapper.deleteByIds(ids);
    }

    public void update(MkWarehouse mkWarehouse) {
        mkWarehouseMapper.updateByPrimaryKeySelective(mkWarehouse);
    }

    public MkWarehouse findById(Long id) {
        return mkWarehouseMapper.selectByPrimaryKey(id);
    }

    public List<MkWarehouse> findByIds(String ids) {
        return mkWarehouseMapper.selectByIds(ids);
    }

    public List<MkWarehouse> findAll() {
        return mkWarehouseMapper.selectAll();
    }

    public PageInfo findList(MkWarehouseDto mkWarehouseDto) {
        if (StringUtils.isBlank(mkWarehouseDto.getSortColumn()) || "default".equals(mkWarehouseDto.getSortColumn())) {
            mkWarehouseDto.setSortColumn("CREATE_TIME");
        }
        if (StringUtils.isBlank(mkWarehouseDto.getSortOrder()) || !"descending".equals(mkWarehouseDto.getSortOrder())) {
            mkWarehouseDto.setSortOrder("ASC");
        } else {
            mkWarehouseDto.setSortOrder("DESC");
        }

        PageHelper.startPage(mkWarehouseDto.getPage(), mkWarehouseDto.getSize());
        List<Map<String, Object>> list = mkWarehouseMapper.findWarehouseList(mkWarehouseDto);
        return new PageInfo(list);
    }


}
