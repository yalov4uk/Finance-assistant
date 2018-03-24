package com.perfect.team.service.request;


import com.perfect.team.service.dto.CategoryUpdateDto;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.request.base.BaseRequest;

public class CategoryUpdateRequest extends AuthRequest {
    private CategoryUpdateDto categoryDto;

    public CategoryUpdateDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryUpdateDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    @Override
    public String toString() {
        return "CategoryUpdateRequest{" +
                "categoryDto=" + categoryDto +
                "} " + super.toString();
    }
}
