package com.store.entity;

import java.math.BigDecimal;

public class Rebate {
    private Integer id;
    private Integer minScore;
    private BigDecimal rebate;

    public Rebate() {
    }

    public Rebate(Integer minScore, BigDecimal rebate) {
        this.minScore = minScore;
        this.rebate = rebate;
    }

    @Override
    public String toString() {
        return "Rebate{" +
                "id=" + id +
                ", minScore=" + minScore +
                ", rebate=" + rebate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public double getRebate() {
        return rebate.doubleValue();
    }

    public void setRebate(double rebate) {
        this.rebate = new BigDecimal(rebate);
    }
}
