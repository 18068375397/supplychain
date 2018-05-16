package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkBrandMapper;
import com.xinyonghang.supplychain.model.MkBrand;
import com.xinyonghang.supplychain.dto.MkBrandDto;
import com.xinyonghang.supplychain.service.MkBrandService;
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
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@Service
@Transactional
public class MkBrandServiceImpl implements MkBrandService {
    @Resource
    private MkBrandMapper mkBrandMapper;

    public void save(MkBrand mkBrand) {
        mkBrandMapper.insertSelective(mkBrand);
    }

    public void save(List<MkBrand> list) {
        mkBrandMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkBrandMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkBrandMapper.deleteByIds(ids);
    }

    public void update(MkBrand mkBrand) {
        mkBrandMapper.updateByPrimaryKeySelective(mkBrand);
    }

    public MkBrand findById(Long id) {
        return mkBrandMapper.selectByPrimaryKey(id);
    }

    public List<MkBrand> findByIds(String ids) {
        return mkBrandMapper.selectByIds(ids);
    }

    public List<MkBrand> findAll() {
        return mkBrandMapper.selectAll();
    }

    public PageInfo findList(MkBrandDto mkBrandDto) {
        if (StringUtils.isBlank(mkBrandDto.getSortColumn()) || "default".equals(mkBrandDto.getSortColumn())) {
            mkBrandDto.setSortColumn("CREATE_TIME");
        }
        if (StringUtils.isBlank(mkBrandDto.getSortOrder()) || !"descending".equals(mkBrandDto.getSortOrder())) {
            mkBrandDto.setSortOrder("ASC");
        } else {
            mkBrandDto.setSortOrder("DESC");
        }

        PageHelper.startPage(mkBrandDto.getPage(), mkBrandDto.getSize());
        List<Map<String, Object>> list = mkBrandMapper.findBrandList(mkBrandDto);
        return new PageInfo(list);
    }


}
