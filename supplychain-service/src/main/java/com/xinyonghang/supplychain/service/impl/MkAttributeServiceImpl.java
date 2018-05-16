package com.xinyonghang.supplychain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.dao.MkAttributeMapper;
import com.xinyonghang.supplychain.dto.MkAttributeDto;
import com.xinyonghang.supplychain.model.MkAttribute;
import com.xinyonghang.supplychain.service.MkAttributeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGeneratorTool on 2018/04/20.
 */
@Service
@Transactional
public class MkAttributeServiceImpl implements MkAttributeService {
    @Resource
    private MkAttributeMapper mkAttributeMapper;

    public void save(MkAttribute mkAttribute) {
        mkAttribute.setStatus("01.enable");
        mkAttributeMapper.insertSelective(mkAttribute);
    }

    public void save(List<MkAttribute> list) {
        mkAttributeMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkAttributeMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkAttributeMapper.deleteByIds(ids);
    }

    public void update(MkAttribute mkAttribute) {
        mkAttributeMapper.updateByPrimaryKeySelective(mkAttribute);
    }

    public MkAttribute findById(Long id) {
        return mkAttributeMapper.selectByPrimaryKey(id);
    }

    public List<MkAttribute> findByIds(String ids) {
        return mkAttributeMapper.selectByIds(ids);
    }

    public List<MkAttribute> findAll() {
        return mkAttributeMapper.selectAll();
    }

    @Override
    public PageInfo findList(MkAttributeDto mkAttributeDto) {
        if (StringUtils.isBlank(mkAttributeDto.getSortColumn()) || "default".equals(mkAttributeDto.getSortColumn())) {
            mkAttributeDto.setSortColumn("CREATE_TIME");
        }
        if (StringUtils.isBlank(mkAttributeDto.getSortOrder()) || !"descending".equals(mkAttributeDto.getSortOrder())) {
            mkAttributeDto.setSortOrder("ASC");
        } else {
            mkAttributeDto.setSortOrder("DESC");
        }

        PageHelper.startPage(mkAttributeDto.getPage(), mkAttributeDto.getSize());
        List<Map<String, Object>> list = mkAttributeMapper.findAttList(mkAttributeDto);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<MkAttribute> getAttributeListByCategoryId(Long categoryId) {
        MkAttributeDto mkAttributeDto = new MkAttributeDto();
        mkAttributeDto.setCategoryId(categoryId);
        return mkAttributeMapper.findList(mkAttributeDto);
    }


}
