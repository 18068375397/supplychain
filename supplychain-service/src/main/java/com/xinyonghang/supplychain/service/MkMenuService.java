package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkMenu;
import com.xinyonghang.supplychain.dto.MkMenuDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGeneratorTool on 2018/04/26.
 */
public interface MkMenuService {
    void save(MkMenu mkMenu);

    void save(List<MkMenu> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkMenu mkMenu);

    MkMenu findById(Long id);

    List<MkMenu> findByIds(String ids);

    List<MkMenu> findAll();//获取所有

    PageInfo findList(MkMenuDto mkMenuDto);

    String findTreeList(Long parentId);

}
