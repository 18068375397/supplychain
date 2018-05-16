package com.xinyonghang.supplychain.model;

import javax.persistence.*;

@Table(name = "MK_SKU_ATTR_RELATION")
public class MkSkuAttrRelation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SKU_ID")
    private String skuId;

    @Column(name = "SKU_ATTR_ID")
    private String skuAttrId;

    @Column(name = "SKU_VALUE")
    private String skuValue;

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
     * @return SKU_VALUE
     */
    public String getSkuValue() {
        return skuValue;
    }

    /**
     * @param skuValue
     */
    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }
}