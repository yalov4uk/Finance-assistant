package com.perfect.team.business.entity;

import com.perfect.team.business.exception.ValidationException;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CategoryType implements Serializable {

    private Long id;

    private String name;

    private BalanceType balanceType;

    private List<Category> categories;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
        OUTCOME;

        public BalanceType getReverse() {
            switch (this) {
                case INCOME:
                    return OUTCOME;
                case OUTCOME:
                    return INCOME;
                default:
                    throw new ValidationException("Wrong balance type");
            }
        }
    }
}
