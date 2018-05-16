package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkBrand;
import com.xinyonghang.supplychain.dto.MkBrandDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkBrandService {
    void save(MkBrand mkBrand);

    void save(List<MkBrand> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkBrand mkBrand);

    MkBrand findById(Long id);

    List<MkBrand> findByIds(String ids);

    List<MkBrand> findAll();//获取所有

    PageInfo findList(MkBrandDto mkBrandDto);
}
