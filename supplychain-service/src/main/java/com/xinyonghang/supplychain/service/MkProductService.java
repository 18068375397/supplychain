package com.xinyonghang.supplychain.service;

import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.model.MkProduct;
import com.xinyonghang.supplychain.dto.MkProductDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGeneratorTool on 2018/04/28.
 */
public interface MkProductService {
    void save(MkProduct mkProduct);

    void save(List<MkProduct> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkProduct mkProduct);

    MkProduct findById(Long id);

    List<MkProduct> findByIds(String ids);

    List<MkProduct> findAll();//获取所有

    PageInfo findList(MkProductDto mkProductDto);

    List<MkProduct> queryList(MkProductDto mkProductDto);

    Result saveProduct(JsonObject params);

}
