package com.xinyonghang.supplychain.model;

import javax.persistence.*;

@Table(name = "MK_PRODUCT_ATTR_RELATION")
public class MkProductAttrRelation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "ATTR_ID")
    private String attrId;

    @Column(name = "VALUE_ID")
    private String valueId;

    @Column(name = "ATTR_VALUE")
    private String attrValue;

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
     * @return ATTR_VALUE
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * @param attrValue
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }
}