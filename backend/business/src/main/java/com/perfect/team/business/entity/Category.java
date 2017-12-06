package com.perfect.team.business.entity;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {

    private Long id;

    private String name;

    private String icon;

    private CategoryType categoryType;

    private User user;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(icon, category.icon) &&
                Objects.equals(categoryType, category.categoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, icon, categoryType);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }

    public enum CategoryType {
        INCOME,
        OUTCOME,
    }
}
