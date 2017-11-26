package com.perfect.team.api.rest.dto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "icon")
    private String icon;

    @JsonProperty(value = "category_type")
    private Integer categoryType;

    @JsonProperty(value = "user_id")
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

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
