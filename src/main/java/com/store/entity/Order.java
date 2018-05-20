package com.store.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer memberId;
    private String customName;
    private String address;
    private String qq;
    private String telephone;
    private String payType;
    private Date orderTime;
    private Integer state;
    private String bz;

    public Order(Integer memberId, String customName, String address, String qq, String telephone, String payType, Date orderTime, Integer state, String bz) {
        this.memberId = memberId;
        this.customName = customName;
        this.address = address;
        this.qq = qq;
        this.telephone = telephone;
        this.payType = payType;
        this.orderTime = orderTime;
        this.state = state;
        this.bz = bz;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", customName='" + customName + '\'' +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", telephone='" + telephone + '\'' +
                ", payType='" + payType + '\'' +
                ", orderTime=" + orderTime +
                ", state=" + state +
                ", bz='" + bz + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
