package com.qs.test6.controller;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Goods {
    private String goodsId;

    //商品名称
    private String goodsName;

    //生成日期
    private String productDate;

    //商品数量
    private Integer count;

    //是否合格
    private Boolean isStandard;

    public Goods() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getStandard() {
        return isStandard;
    }

    public void setStandard(Boolean standard) {
        isStandard = standard;
    }
}
