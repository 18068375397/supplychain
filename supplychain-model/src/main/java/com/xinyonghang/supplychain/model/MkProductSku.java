package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "MK_PRODUCT_SKU")
public class MkProductSku {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SKU_ID")
    private String skuId;

    @Column(name = "CODE")
    private String code;

    @Column(name = "SKU_CODE")
    private String skuCode;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "BUY_PRICE")
    private BigDecimal buyPrice;

    @Column(name = "SALE_PRICE")
    private BigDecimal salePrice;

    @Column(name = "PRICE_UNIT")
    private Long priceUnit;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "SKU_DESC")
    private String skuDesc;

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
     * @return CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return SKU_CODE
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * @param skuCode
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
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
     * @return QUANTITY
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return BUY_PRICE
     */
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    /**
     * @param buyPrice
     */
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * @return SALE_PRICE
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return PRICE_UNIT
     */
    public Long getPriceUnit() {
        return priceUnit;
    }

    /**
     * @param priceUnit
     */
    public void setPriceUnit(Long priceUnit) {
        this.priceUnit = priceUnit;
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
     * @return SKU_DESC
     */
    public String getSkuDesc() {
        return skuDesc;
    }

    /**
     * @param skuDesc
     */
    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
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