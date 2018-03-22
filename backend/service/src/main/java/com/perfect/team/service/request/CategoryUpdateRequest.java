package com.perfect.team.service.request;


import com.perfect.team.service.dto.CategoryUpdateDto;
import com.perfect.team.service.request.base.BaseRequest;

public class CategoryUpdateRequest extends BaseRequest {
    private CategoryUpdateDto categoryDto;

    public CategoryUpdateDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryUpdateDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
