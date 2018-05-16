package com.xinyonghang.supplychain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MK_SAIL_ORDER")
public class MkSailOrder {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SAIL_CODE")
    private String sailCode;

    @Column(name = "SUPPLIE_ID")
    private String supplieId;

    @Column(name = "TOTAL_MONEY")
    private Long totalMoney;

    @Column(name = "SAIL_NUM")
    private Integer sailNum;

    @Column(name = "PLAN_CHARGE")
    private Long planCharge;

    @Column(name = "BILL_STATUS")
    private String billStatus;

    @Column(name = "WAREHOUSING_STATUS")
    private String warehousingStatus;

    @Column(name = "BILL_TIME")
    private Date billTime;

    @Column(name = "AGENT")
    private String agent;

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
     * @return SUPPLIE_ID
     */
    public String getSupplieId() {
        return supplieId;
    }

    /**
     * @param supplieId
     */
    public void setSupplieId(String supplieId) {
        this.supplieId = supplieId;
    }

    /**
     * @return TOTAL_MONEY
     */
    public Long getTotalMoney() {
        return totalMoney;
    }

    /**
     * @param totalMoney
     */
    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
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
     * @return PLAN_CHARGE
     */
    public Long getPlanCharge() {
        return planCharge;
    }

    /**
     * @param planCharge
     */
    public void setPlanCharge(Long planCharge) {
        this.planCharge = planCharge;
    }

    /**
     * @return BILL_STATUS
     */
    public String getBillStatus() {
        return billStatus;
    }

    /**
     * @param billStatus
     */
    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    /**
     * @return WAREHOUSING_STATUS
     */
    public String getWarehousingStatus() {
        return warehousingStatus;
    }

    /**
     * @param warehousingStatus
     */
    public void setWarehousingStatus(String warehousingStatus) {
        this.warehousingStatus = warehousingStatus;
    }

    /**
     * @return BILL_TIME
     */
    public Date getBillTime() {
        return billTime;
    }

    /**
     * @param billTime
     */
    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    /**
     * @return AGENT
     */
    public String getAgent() {
        return agent;
    }

    /**
     * @param agent
     */
    public void setAgent(String agent) {
        this.agent = agent;
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