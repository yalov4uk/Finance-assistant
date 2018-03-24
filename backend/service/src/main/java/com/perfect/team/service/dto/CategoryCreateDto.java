package com.perfect.team.service.dto;

import com.perfect.team.business.model.Category;

public class CategoryCreateDto {
    private String name;
    private String icon;
    private Category.Type type;

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

    public Category.Type getType() {
        return type;
    }

    public void setType(Category.Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CategoryCreateDto{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                '}';
    }
}
