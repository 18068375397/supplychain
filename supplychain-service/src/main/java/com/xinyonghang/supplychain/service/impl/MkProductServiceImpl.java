package com.xinyonghang.supplychain.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dao.MkProductAttrRelationMapper;
import com.xinyonghang.supplychain.dao.MkProductMapper;
import com.xinyonghang.supplychain.dao.MkProductSkuMapper;
import com.xinyonghang.supplychain.dao.MkSkuAttrRelationMapper;
import com.xinyonghang.supplychain.dto.MkSkuAttrRelationDto;
import com.xinyonghang.supplychain.model.MkProduct;
import com.xinyonghang.supplychain.dto.MkProductDto;
import com.xinyonghang.supplychain.model.MkProductAttrRelation;
import com.xinyonghang.supplychain.model.MkProductSku;
import com.xinyonghang.supplychain.model.MkSkuAttrRelation;
import com.xinyonghang.supplychain.service.MkProductService;
import com.xinyonghang.supplychain.utils.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Created by CodeGeneratorTool on 2018/04/28.
 */
@Service
@Transactional
public class MkProductServiceImpl implements MkProductService {
    @Resource
    private MkProductMapper mkProductMapper;

    @Resource
    private MkProductAttrRelationMapper mkProductAttrRelationMapper;

    @Resource
    private MkProductSkuMapper mkProductSkuMapper;

    @Resource
    private MkSkuAttrRelationMapper mkSkuAttrRelationMapper;

    public void save(MkProduct mkProduct) {
        mkProductMapper.insertSelective(mkProduct);
    }

    public void save(List<MkProduct> list) {
        mkProductMapper.insertList(list);
    }

    public void deleteById(Long id) {
        mkProductMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mkProductMapper.deleteByIds(ids);
    }

    public void update(MkProduct mkProduct) {
        mkProductMapper.updateByPrimaryKeySelective(mkProduct);
    }

    public MkProduct findById(Long id) {
        return mkProductMapper.selectByPrimaryKey(id);
    }

    public List<MkProduct> findByIds(String ids) {
        return mkProductMapper.selectByIds(ids);
    }

    public List<MkProduct> findAll() {
        return mkProductMapper.selectAll();
    }

    public PageInfo findList(MkProductDto mkProductDto) {
        if (StringUtils.isBlank(mkProductDto.getSortColumn()) || "default".equals(mkProductDto.getSortColumn())) {
            mkProductDto.setSortColumn("CREATE_TIME");
        }
        if (StringUtils.isBlank(mkProductDto.getSortOrder()) || !"descending".equals(mkProductDto.getSortOrder())) {
            mkProductDto.setSortOrder("ASC");
        } else {
            mkProductDto.setSortOrder("DESC");
        }

        PageHelper.startPage(mkProductDto.getPage(), mkProductDto.getSize());
//        System.out.println(mkProductDto.getSortColumn());

        List<Map<String, Object>> list = mkProductMapper.findProductList(mkProductDto);
        return new PageInfo(list);
    }

    public List<MkProduct> queryList(MkProductDto mkProductDto) {
        List<MkProduct> list = mkProductMapper.findList(mkProductDto);
        return list;
    }

    @Override
    public Result saveProduct(JsonObject params) {
        System.out.println(params);
        MkProduct product = new MkProduct();
        String productId = params.get("productId").getAsString();
        // 判断productId 非空(人工设置)
        if (StringUtils.isNotBlank(productId)) {
            product.setProductId(productId);
            // 判断商品编码唯一
            if (mkProductMapper.selectOne(product) != null) {
                product = null;
                return ResultGenerator.genFailResult(0, "商品编号已经存在");
            }
        } else {
            product.setProductId(UUID.randomUUID().toString());
        }


        // Step.1  保存商品
        product.setBrandId(params.get("brandId").getAsLong());
        product.setCategoryId(params.get("attributeThree").getAsLong());
        product.setParentId(params.get("attributeTwo").getAsLong());
        product.setTopId(params.get("attributeOne").getAsLong());
        product.setProductName(params.get("productName").getAsString());
        product.setSpecification(params.get("specification").getAsString());
        product.setUnit(params.get("unit").getAsString());

        Boolean isWeight = params.get("isWeight").getAsBoolean();
        if (isWeight) {
            product.setIsWeight("01.yes");
            product.setWeight(params.get("weight").getAsLong());
            product.setWeightUnit(params.get("weightUnit").getAsString());
        } else {
            product.setIsWeight("02.no");
        }
        mkProductMapper.insert(product);

        // Step.2 保存商品拓展属性
        if (params.has("tuozhanArray")) {
            JsonArray attrArray = GsonUtil.StringToJsonArray(params.get("tuozhanArray").getAsString());
            MkProductAttrRelation mkProductAttrRelation = null;
            List<MkProductAttrRelation> list = new ArrayList<MkProductAttrRelation>();
            for (JsonElement jsonElement : attrArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                mkProductAttrRelation = new MkProductAttrRelation();
                mkProductAttrRelation.setAttrId(jsonObject.get("attrId").getAsString());
                mkProductAttrRelation.setProductId(product.getProductId());
                mkProductAttrRelation.setAttrValue(jsonObject.get("value").getAsString());
                list.add(mkProductAttrRelation);
            }
            mkProductAttrRelationMapper.insertList(list);
        }

        // Step.3 保存商品SKU
        MkProductSku mkProductSku = null;
        MkSkuAttrRelation mkSkuAttrRelation = null;
        if (params.has("skuArray")) {
            List<MkProductSku> pList = new ArrayList<MkProductSku>();
            List<MkSkuAttrRelation> sList = new ArrayList<MkSkuAttrRelation>();
            JsonArray skuArray = GsonUtil.StringToJsonArray(params.get("skuArray").getAsString());
            // 解析productsku数组
            for (JsonElement element : skuArray) {
                JsonArray skuValue = element.getAsJsonArray();
                String skuID = UUID.randomUUID().toString();
                mkProductSku = new MkProductSku();
                mkProductSku.setProductId(product.getProductId());
                mkProductSku.setSkuId(skuID);
                // 解析sku值
                for (int i = 0; i < skuValue.size(); i++) {
                    if (i == skuValue.size() - 2) {
                        mkProductSku.setBuyPrice(skuValue.get(i).getAsBigDecimal());
                    } else if (i == skuValue.size() - 1) {
                        mkProductSku.setSalePrice(skuValue.get(i).getAsBigDecimal());
                    } else if (i == skuValue.size() - 3) {
                        String sku = skuValue.get(i).getAsString();
                        if (StringUtils.isNotBlank(sku)) {
                            mkProductSku.setSkuId(sku);
                        }
                    } else {
                        JsonObject jsonObject = skuValue.get(i).getAsJsonObject();
                        mkSkuAttrRelation = new MkSkuAttrRelation();
                        mkSkuAttrRelation.setSkuAttrId(jsonObject.get("skuAttrId").getAsString());
                        mkSkuAttrRelation.setSkuValue(jsonObject.get("skuValue").getAsString());
                        mkSkuAttrRelation.setSkuId(skuID);
                        sList.add(mkSkuAttrRelation);
                    }
                }
                pList.add(mkProductSku);
            }
            mkProductSkuMapper.insertList(pList);
            mkSkuAttrRelationMapper.insertList(sList);
        } else {
            mkProductSku = new MkProductSku();
            mkProductSku.setProductId(product.getProductId());
            mkProductSku.setSkuId(UUID.randomUUID().toString());
            mkProductSkuMapper.insert(mkProductSku);
        }

        return ResultGenerator.genSuccessResult();
    }


}
