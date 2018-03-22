package com.perfect.team.service.request;


import com.perfect.team.service.dto.CategoryCreateDto;
import com.perfect.team.service.request.base.BaseRequest;

public class CategoryCreateRequest extends BaseRequest {
    private CategoryCreateDto categoryDto;

    public CategoryCreateDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryCreateDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
