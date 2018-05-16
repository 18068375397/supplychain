package com.xinyonghang.supplychain.service.impl;

import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.dao.MkProductSkuMapper;
import com.xinyonghang.supplychain.model.MkProductSku;
import com.xinyonghang.supplychain.dto.MkProductSkuDto;
import com.xinyonghang.supplychain.service.MkProductSkuService;
import com.xinyonghang.supplychain.core.AbstractService;
import com.xinyonghang.supplychain.utils.GsonUtil;
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
public class MkProductSkuServiceImpl implements MkProductSkuService {
    @Resource
    private MkProductSkuMapper mkProductSkuMapper;

    public void save(MkProductSku mkProductSku) {
        mkProductSkuMapper.insertSelective(mkProductSku);
    }

    public void save(List<MkProductSku> list) {
        mkProductSkuMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkProductSkuMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkProductSkuMapper.deleteByIds(ids);
    }

    public void update(MkProductSku mkProductSku) {
        mkProductSkuMapper.updateByPrimaryKeySelective(mkProductSku);
    }

    public MkProductSku findById(Long id) {
        return mkProductSkuMapper.selectByPrimaryKey(id);
    }

    public List<MkProductSku> findByIds(String ids) {
        return mkProductSkuMapper.selectByIds(ids);
    }

    public List<MkProductSku> findAll() {
        return mkProductSkuMapper.selectAll();
    }

    public PageInfo findList(MkProductSkuDto mkProductSkuDto) {
        PageHelper.startPage(mkProductSkuDto.getPage(), mkProductSkuDto.getSize());
        List<MkProductSku> list = mkProductSkuMapper.findList(mkProductSkuDto);
        return new PageInfo(list);
    }

    @Override
    public List<Map<String, Object>> getProductSkuList(Map<String, Object> params) {
        return mkProductSkuMapper.getProductSkuList(params);
    }
}
