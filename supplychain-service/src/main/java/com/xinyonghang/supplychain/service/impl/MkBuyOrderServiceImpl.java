package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkBuyOrderMapper;
import com.xinyonghang.supplychain.model.MkBuyOrder;
import com.xinyonghang.supplychain.dto.MkBuyOrderDto;
import com.xinyonghang.supplychain.service.MkBuyOrderService;
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
public class MkBuyOrderServiceImpl implements MkBuyOrderService {
    @Resource
    private MkBuyOrderMapper mkBuyOrderMapper;

    public void save(MkBuyOrder mkBuyOrder) {
        mkBuyOrderMapper.insertSelective(mkBuyOrder);
    }

    public void save(List<MkBuyOrder> list) {
        mkBuyOrderMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkBuyOrderMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkBuyOrderMapper.deleteByIds(ids);
    }

    public void update(MkBuyOrder mkBuyOrder) {
        mkBuyOrderMapper.updateByPrimaryKeySelective(mkBuyOrder);
    }

    public MkBuyOrder findById(Long id) {
        return mkBuyOrderMapper.selectByPrimaryKey(id);
    }

    public List<MkBuyOrder> findByIds(String ids) {
        return mkBuyOrderMapper.selectByIds(ids);
    }

    public List<MkBuyOrder> findAll() {
        return mkBuyOrderMapper.selectAll();
    }

    public PageInfo findList(MkBuyOrderDto mkBuyOrderDto) {
        if (StringUtils.isBlank(mkBuyOrderDto.getSortColumn()) || "default".equals(mkBuyOrderDto.getSortColumn())) {
            mkBuyOrderDto.setSortColumn("CREATE_TIME");
        }
        if (StringUtils.isBlank(mkBuyOrderDto.getSortOrder()) || !"descending".equals(mkBuyOrderDto.getSortOrder())) {
            mkBuyOrderDto.setSortOrder("ASC");
        } else {
            mkBuyOrderDto.setSortOrder("DESC");
        }

        PageHelper.startPage(mkBuyOrderDto.getPage(), mkBuyOrderDto.getSize());

        List<Map<String, Object>> list = mkBuyOrderMapper.findBuyOrderList(mkBuyOrderDto);

        return new PageInfo(list);
    }


}
