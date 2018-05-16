package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MK_SAIL_ORDER_DETAIL")
public class MkSailOrderDetail {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SAIL_CODE")
    private String sailCode;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "SKU_ID")
    private String skuId;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "SAIL_NUM")
    private Integer sailNum;

    @Column(name = "UNIT_PRICE")
    private Long unitPrice;

    @Column(name = "TAX_RATIO")
    private Integer taxRatio;

    @Column(name = "TAX")
    private Long tax;

    @Column(name = "COMPLETED_NUM")
    private Integer completedNum;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LAST_OPERATOR_TIME")
    private Date lastOperatorTime;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "LAST_OPERATOR")
    private String lastOperator;

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
     * @return SAIL_CODE
     */
    public String getSailCode() {
        return sailCode;
    }

    /**
     * @param sailCode
     */
    public void setSailCode(String sailCode) {
        this.sailCode = sailCode;
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
     * @return SKU_ID
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * @param skuId
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * @return WEIGHT
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return SAIL_NUM
     */
    public Integer getSailNum() {
        return sailNum;
    }

    /**
     * @param sailNum
     */
    public void setSailNum(Integer sailNum) {
        this.sailNum = sailNum;
    }

    /**
     * @return UNIT_PRICE
     */
    public Long getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice
     */
    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return TAX_RATIO
     */
    public Integer getTaxRatio() {
        return taxRatio;
    }

    /**
     * @param taxRatio
     */
    public void setTaxRatio(Integer taxRatio) {
        this.taxRatio = taxRatio;
    }

    /**
     * @return TAX
     */
    public Long getTax() {
        return tax;
    }

    /**
     * @param tax
     */
    public void setTax(Long tax) {
        this.tax = tax;
    }

    /**
     * @return COMPLETED_NUM
     */
    public Integer getCompletedNum() {
        return completedNum;
    }

    /**
     * @param completedNum
     */
    public void setCompletedNum(Integer completedNum) {
        this.completedNum = completedNum;
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
}