package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkSupplier;
import com.xinyonghang.supplychain.dto.MkSupplierDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkSupplierService {
    void save(MkSupplier mkSupplier);

    void save(List<MkSupplier> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSupplier mkSupplier);

    MkSupplier findById(Long id);

    List<MkSupplier> findByIds(String ids);

    List<MkSupplier> findAll();//获取所有

    PageInfo findList(MkSupplierDto mkSupplierDto);
}
