package com.store.entity;

import java.math.BigDecimal;

public class Order_Detail {
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private BigDecimal price;
    private Integer number;

    public Order_Detail() {
    }

    public Order_Detail(Integer orderId, Integer goodsId, BigDecimal price, Integer number) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.price = price;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", price=" + price +
                ", number=" + number +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
