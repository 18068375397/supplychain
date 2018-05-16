package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MK_SKU_ATTRIBUTE")
public class MkSkuAttribute {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SKU_ATTR_ID")
    private String skuAttrId;

    @Column(name = "SKU_ATTR_NAME")
    private String skuAttrName;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "TOP_ID")
    private Long topId;

    @Column(name = "COLUMN_TYPE")
    private String columnType;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SORT")
    private Integer sort;

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
     * @return SKU_ATTR_ID
     */
    public String getSkuAttrId() {
        return skuAttrId;
    }

    /**
     * @param skuAttrId
     */
    public void setSkuAttrId(String skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    /**
     * @return SKU_ATTR_NAME
     */
    public String getSkuAttrName() {
        return skuAttrName;
    }

    /**
     * @param skuAttrName
     */
    public void setSkuAttrName(String skuAttrName) {
        this.skuAttrName = skuAttrName;
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
     * @return COLUMN_TYPE
     */
    public String getColumnType() {
        return columnType;
    }

    /**
     * @param columnType
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
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
     * @return SORT
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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