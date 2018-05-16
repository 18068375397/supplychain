package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MK_ATTRIBUTE")
public class MkAttribute {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ATTR_ID")
    private String attrId;

    @Column(name = "ATTR_NAME")
    private String attrName;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "TOP_ID")
    private Long topId;

    @Column(name = "ATTR_TYPE")
    private String attrType;

    @Column(name = "IS_REQUIRED")
    private String isRequired;

    @Column(name = "IS_SEARCH")
    private String isSearch;

    @Column(name = "INPUT_TYPE")
    private String inputType;

    @Column(name = "COLUMN_TYPE")
    private String columnType;

    @Column(name = "ATTR_VALUES")
    private String attrValues;

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
     * @return ATTR_ID
     */
    public String getAttrId() {
        return attrId;
    }

    /**
     * @param attrId
     */
    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    /**
     * @return ATTR_NAME
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * @param attrName
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
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
     * @return ATTR_TYPE
     */
    public String getAttrType() {
        return attrType;
    }

    /**
     * @param attrType
     */
    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    /**
     * @return IS_REQUIRED
     */
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * @param isRequired
     */
    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * @return IS_SEARCH
     */
    public String getIsSearch() {
        return isSearch;
    }

    /**
     * @param isSearch
     */
    public void setIsSearch(String isSearch) {
        this.isSearch = isSearch;
    }

    /**
     * @return INPUT_TYPE
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * @param inputType
     */
    public void setInputType(String inputType) {
        this.inputType = inputType;
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
     * @return ATTR_VALUES
     */
    public String getAttrValues() {
        return attrValues;
    }

    /**
     * @param attrValues
     */
    public void setAttrValues(String attrValues) {
        this.attrValues = attrValues;
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