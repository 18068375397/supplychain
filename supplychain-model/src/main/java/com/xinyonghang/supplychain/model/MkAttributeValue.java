package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MK_ATTRIBUTE_VALUE")
public class MkAttributeValue {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALUE_ID")
    private String valueId;

    @Column(name = "ATTR_ID")
    private String attrId;

    @Column(name = "VALUE_NAME")
    private String valueName;

    @Column(name = "SORT")
    private Integer sort;

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
     * @return VALUE_ID
     */
    public String getValueId() {
        return valueId;
    }

    /**
     * @param valueId
     */
    public void setValueId(String valueId) {
        this.valueId = valueId;
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
     * @return VALUE_NAME
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * @param valueName
     */
    public void setValueName(String valueName) {
        this.valueName = valueName;
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