package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkSkuAttributeMapper;
import com.xinyonghang.supplychain.dto.MkAttributeDto;
import com.xinyonghang.supplychain.model.MkAttribute;
import com.xinyonghang.supplychain.model.MkSkuAttribute;
import com.xinyonghang.supplychain.dto.MkSkuAttributeDto;
import com.xinyonghang.supplychain.service.MkSkuAttributeService;
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
 * Created by CodeGeneratorTool on 2018/05/03.
 */
@Service
@Transactional
public class MkSkuAttributeServiceImpl implements MkSkuAttributeService {
    @Resource
    private MkSkuAttributeMapper mkSkuAttributeMapper;

    public void save(MkSkuAttribute mkSkuAttribute) {
        mkSkuAttributeMapper.insertSelective(mkSkuAttribute);
    }

    public void save(List<MkSkuAttribute> list) {
        mkSkuAttributeMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkSkuAttributeMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkSkuAttributeMapper.deleteByIds(ids);
    }

    public void update(MkSkuAttribute mkSkuAttribute) {
        mkSkuAttributeMapper.updateByPrimaryKeySelective(mkSkuAttribute);
    }

    public MkSkuAttribute findById(Long id) {
        return mkSkuAttributeMapper.selectByPrimaryKey(id);
    }

    public List<MkSkuAttribute> findByIds(String ids) {
        return mkSkuAttributeMapper.selectByIds(ids);
    }

    public List<MkSkuAttribute> findAll() {
        return mkSkuAttributeMapper.selectAll();
    }

    public PageInfo findList(MkSkuAttributeDto mkSkuAttributeDto) {
        if (StringUtils.isBlank(mkSkuAttributeDto.getSortColumn()) || "default".equals(mkSkuAttributeDto.getSortColumn())) {
            mkSkuAttributeDto.setSortColumn("CREATE_TIME");
        }
        if (StringUtils.isBlank(mkSkuAttributeDto.getSortOrder()) || !"descending".equals(mkSkuAttributeDto.getSortOrder())) {
            mkSkuAttributeDto.setSortOrder("ASC");
        } else {
            mkSkuAttributeDto.setSortOrder("DESC");
        }

        PageHelper.startPage(mkSkuAttributeDto.getPage(), mkSkuAttributeDto.getSize());
        List<Map<String, Object>> list = mkSkuAttributeMapper.findSkuList(mkSkuAttributeDto);
        return new PageInfo(list);
    }

    @Override
    public List<MkSkuAttribute> getSkuAttrListByCategoryId(Long categoryId) {
        MkSkuAttributeDto mkSkuAttributeDto = new MkSkuAttributeDto();
        mkSkuAttributeDto.setCategoryId(categoryId);
        return mkSkuAttributeMapper.findList(mkSkuAttributeDto);
    }

}
