package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MK_PRODUCT")
public class MkProduct {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "MERCHANT_CODE")
    private String merchantCode;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "TOP_ID")
    private Long topId;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "IS_WEIGHT")
    private String isWeight;

    @Column(name = "WEIGHT")
    private Long weight;

    @Column(name = "WEIGHT_UNIT")
    private String weightUnit;

    @Column(name = "SPECIFICATION")
    private String specification;

    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "INTRODUCTION")
    private String introduction;

    @Column(name = "ATTR_DESC")
    private String attrDesc;

    @Column(name = "SEARCH_DESC")
    private String searchDesc;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "LAST_OPERATOR")
    private String lastOperator;

    @Column(name = "LAST_OPERATOR_TIME")
    private Date lastOperatorTime;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return PRODUCT_ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return PRODUCT_NAME
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return BRAND_ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * @param brandId
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * @return MERCHANT_CODE
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * @param merchantCode
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    /**
     * @return CATEGORY_ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return PARENT_ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return TOP_ID
     */
    public Long getTopId() {
        return topId;
    }

    /**
     * @param topId
     */
    public void setTopId(Long topId) {
        this.topId = topId;
    }

    /**
     * @return UNIT
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return IS_WEIGHT
     */
    public String getIsWeight() {
        return isWeight;
    }

    /**
     * @param isWeight
     */
    public void setIsWeight(String isWeight) {
        this.isWeight = isWeight;
    }

    /**
     * @return WEIGHT
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * @return WEIGHT_UNIT
     */
    public String getWeightUnit() {
        return weightUnit;
    }

    /**
     * @param weightUnit
     */
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    /**
     * @return SPECIFICATION
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return SUPPLIER_ID
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return INTRODUCTION
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return ATTR_DESC
     */
    public String getAttrDesc() {
        return attrDesc;
    }

    /**
     * @param attrDesc
     */
    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    /**
     * @return SEARCH_DESC
     */
    public String getSearchDesc() {
        return searchDesc;
    }

    /**
     * @param searchDesc
     */
    public void setSearchDesc(String searchDesc) {
        this.searchDesc = searchDesc;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return OPERATOR
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return LAST_OPERATOR
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * @param lastOperator
     */
    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    /**
     * @return LAST_OPERATOR_TIME
     */
    public Date getLastOperatorTime() {
        return lastOperatorTime;
    }

    /**
     * @param lastOperatorTime
     */
    public void setLastOperatorTime(Date lastOperatorTime) {
        this.lastOperatorTime = lastOperatorTime;
    }
}