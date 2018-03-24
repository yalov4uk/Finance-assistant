package com.perfect.team.service.dto;

import com.perfect.team.business.model.Category;

public class CategoryReadDto {
    private Long id;
    private String name;
    private String icon;
    private Category.Type type;
    private Long userId;

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

    public Category.Type getType() {
        return type;
    }

    public void setType(Category.Type type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CategoryReadDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", userId=" + userId +
                '}';
    }
}
