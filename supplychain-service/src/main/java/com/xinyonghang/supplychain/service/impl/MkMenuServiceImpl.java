package com.xinyonghang.supplychain.service.impl;

import com.xinyonghang.supplychain.dao.MkMenuMapper;
import com.xinyonghang.supplychain.model.MkMenu;
import com.xinyonghang.supplychain.dto.MkMenuDto;
import com.xinyonghang.supplychain.service.MkMenuService;
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
 * Created by CodeGeneratorTool on 2018/04/26.
 */
@Service
@Transactional
public class MkMenuServiceImpl implements MkMenuService {
    @Resource
    private MkMenuMapper mkMenuMapper;

    public void save(MkMenu mkMenu) {
        mkMenuMapper.insertSelective(mkMenu);
    }

    public void save(List<MkMenu> list) {
        mkMenuMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkMenuMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkMenuMapper.deleteByIds(ids);
    }

    public void update(MkMenu mkMenu) {
        mkMenuMapper.updateByPrimaryKeySelective(mkMenu);
    }

    public MkMenu findById(Long id) {
        return mkMenuMapper.selectByPrimaryKey(id);
    }

    public List<MkMenu> findByIds(String ids) {
        return mkMenuMapper.selectByIds(ids);
    }

    public List<MkMenu> findAll() {
        return mkMenuMapper.selectAll();
    }

    public PageInfo findList(MkMenuDto mkMenuDto) {
        PageHelper.startPage(mkMenuDto.getPage(), mkMenuDto.getSize());
        List<MkMenu> list = mkMenuMapper.findList(mkMenuDto);
        return new PageInfo(list);
    }

    @Override
    public String findTreeList(Long parentId) {
        return "[" + getTreeByParentIdJSON(parentId) + "]";
    }


    private String getTreeByParentIdJSON(Long id) {
        StringBuffer stringBuffer = new StringBuffer();
        List<MkMenu> list = mkMenuMapper.getMenuByParentId(id);
        for (int i = 0; i < list.size(); i++) {
            MkMenu menu = list.get(i);
            stringBuffer.append("{text:'" + menu.getMenuName() + "'");
            if (StringUtils.isNotBlank(menu.getMenuUrl())) {
                stringBuffer.append(",tabs:'" + menu.getMenuName() + "',href:window.baseUrl + \'" + menu.getMenuUrl() + "\'");
            } else {
                stringBuffer.append(",href:'#'");
            }

            if (!getTreeByParentIdJSON(menu.getMenuId()).isEmpty()) {
                stringBuffer.append(",nodes:[" + getTreeByParentIdJSON(menu.getMenuId()) + "] ");
            }
            if (i == list.size() - 1) {
                stringBuffer.append("}");
            } else {
                stringBuffer.append("},");
            }
        }
        return stringBuffer.toString();
    }


}
