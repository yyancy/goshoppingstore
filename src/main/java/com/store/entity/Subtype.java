package com.store.entity;

public class Subtype {
    private Integer id;
    private Integer superType;
    private String  typeName;

    public Subtype(){}

    public Subtype(Integer superType, String typeName) {
        this.superType = superType;
        this.typeName = typeName;
    }

    public Subtype(Integer id, Integer superType, String typeName) {
        this.id = id;
        this.superType = superType;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Subtype{" +
                "id=" + id +
                ", superType=" + superType +
                ", typeName=" + typeName +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuperType() {
        return superType;
    }

    public void setSuperType(Integer superType) {
        this.superType = superType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
