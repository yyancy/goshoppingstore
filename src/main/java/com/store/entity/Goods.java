package com.store.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;
    private Integer tid;
    private String name;
    private String introduce;
    private BigDecimal price;
    private BigDecimal reducePrice;
    private String  photo;
    private Date inTime;
    private Integer saleNumber = 0;
    private Integer hit = 0;

    public Goods() {
    }

    public Goods(Integer tid, String name, String introduce, double price, double reducePrice, String photo, Date inTime) {
        this.tid = tid;
        this.name = name;
        this.introduce = introduce;
        this.price = new BigDecimal(price);
        this.reducePrice = new BigDecimal(reducePrice);
        this.photo = photo;
        this.inTime = inTime;
    }

    public Goods(Integer tid, String name, String introduce, double price, double reducePrice, String photo, Date inTime, Integer saleNumber, Integer hit) {
        this.tid = tid;
        this.name = name;
        this.introduce = introduce;
        this.price = new BigDecimal(price);
        this.reducePrice =new BigDecimal(reducePrice);
        this.photo = photo;
        this.inTime = inTime;
        this.saleNumber = saleNumber;
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", tid=" + tid +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", price=" + price +
                ", reducePrice=" + reducePrice +
                ", photo='" + photo + '\'' +
                ", inTime=" + inTime +
                ", saleNumber='" + saleNumber + '\'' +
                ", hit=" + hit +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price =price;
    }

    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getIntime() {
        return inTime;
    }

    public void setIntime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }
}
