package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "MK_SUPPLIER")
public class MkSupplier {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUPPLIER_ID")
    private String supplierId;

    @Column(name = "SUPPLIER_NAME")
    private String supplierName;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "BUSINESS_NATURE")
    private String businessNature;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "INTRODUCTION")
    private String introduction;

    @Column(name = "SCOPES")
    private String scopes;

    @Column(name = "BUSINESS_LICENSE")
    private String businessLicense;

    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @Column(name = "DEPOSIT_MONEY")
    private BigDecimal depositMoney;

    @Column(name = "SERVICE_MONEY")
    private BigDecimal serviceMoney;

    @Column(name = "OPEN_TYPE")
    private String openType;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "OPEN_TIME")
    private Date openTime;

    @Column(name = "OPEN_OPERATOR")
    private String openOperator;

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
     * @return SUPPLIER_ID
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return SUPPLIER_NAME
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return MEMBER_ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return BUSINESS_NATURE
     */
    public String getBusinessNature() {
        return businessNature;
    }

    /**
     * @param businessNature
     */
    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    /**
     * @return LOGO
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
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
     * @return SCOPES
     */
    public String getScopes() {
        return scopes;
    }

    /**
     * @param scopes
     */
    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    /**
     * @return BUSINESS_LICENSE
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * @param businessLicense
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * @return PAYMENT_TYPE
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return DEPOSIT_MONEY
     */
    public BigDecimal getDepositMoney() {
        return depositMoney;
    }

    /**
     * @param depositMoney
     */
    public void setDepositMoney(BigDecimal depositMoney) {
        this.depositMoney = depositMoney;
    }

    /**
     * @return SERVICE_MONEY
     */
    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    /**
     * @param serviceMoney
     */
    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    /**
     * @return OPEN_TYPE
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * @param openType
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }

    /**
     * @return START_TIME
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return END_TIME
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
     * @return OPEN_TIME
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * @param openTime
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * @return OPEN_OPERATOR
     */
    public String getOpenOperator() {
        return openOperator;
    }

    /**
     * @param openOperator
     */
    public void setOpenOperator(String openOperator) {
        this.openOperator = openOperator;
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