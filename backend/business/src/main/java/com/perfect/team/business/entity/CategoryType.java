package com.perfect.team.business.entity;

import java.io.Serializable;
import java.util.Objects;

public class CategoryType implements Serializable {

    private Long id;

    private String name;

    private BalanceType balanceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryType)) return false;
        CategoryType that = (CategoryType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                balanceType == that.balanceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balanceType);
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balanceType=" + balanceType +
                '}';
    }

    public enum BalanceType {
        INCOME,
        OUTCOME,
    }
}
