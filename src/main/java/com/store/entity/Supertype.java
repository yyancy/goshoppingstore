package com.store.entity;

import java.util.Objects;

public class Supertype {
    private Integer id;
    private String typeName;

    public Supertype(){}

    public Supertype(String typeName) {
        this.typeName = typeName;
    }

    public Supertype(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Supertype{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supertype supertype = (Supertype) o;
        return Objects.equals(id, supertype.id) &&
                Objects.equals(typeName, supertype.typeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, typeName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
