package com.perfect.team.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryUpdateDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "icon")
    private String icon;

    @JsonProperty(value = "categoryTypeId")
    private Long categoryTypeId;

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

    public Long getCategoryTypeId() {
        return categoryTypeId;
    }

    public void setCategoryTypeId(Long categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }
}
