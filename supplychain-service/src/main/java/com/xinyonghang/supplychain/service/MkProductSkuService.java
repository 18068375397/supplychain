package com.xinyonghang.supplychain.service;

import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.model.MkProductSku;
import com.xinyonghang.supplychain.dto.MkProductSkuDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
public interface MkProductSkuService {
    void save(MkProductSku mkProductSku);

    void save(List<MkProductSku> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkProductSku mkProductSku);

    MkProductSku findById(Long id);

    List<MkProductSku> findByIds(String ids);

    List<MkProductSku> findAll();//获取所有

    PageInfo findList(MkProductSkuDto mkProductSkuDto);

    /**
     * 按品牌,类目 查询商品SKU列表(采购挑选)
     *
     * @return
     */
    List<Map<String, Object>> getProductSkuList(Map<String, Object> params);
}
