package com.xinyonghang.supplychain.service;

import com.xinyonghang.supplychain.model.MkAttribute;
import com.xinyonghang.supplychain.model.MkSkuAttribute;
import com.xinyonghang.supplychain.dto.MkSkuAttributeDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/05/03.
 */
public interface MkSkuAttributeService {
    void save(MkSkuAttribute mkSkuAttribute);

    void save(List<MkSkuAttribute> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(MkSkuAttribute mkSkuAttribute);

    MkSkuAttribute findById(Long id);

    List<MkSkuAttribute> findByIds(String ids);

    List<MkSkuAttribute> findAll();//获取所有

    PageInfo findList(MkSkuAttributeDto mkSkuAttributeDto);

    /**
     * 按类目categoryId 查询销售属性
     *
     * @param categoryId
     * @return
     */
    List<MkSkuAttribute> getSkuAttrListByCategoryId(Long categoryId);
}
