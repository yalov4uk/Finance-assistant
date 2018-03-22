package com.perfect.team.service.response;


import com.perfect.team.service.dto.CategoryReadDto;
import com.perfect.team.service.response.base.BaseResponse;

public class CategoryResponse extends BaseResponse {
    private CategoryReadDto categoryReadDto;

    public CategoryReadDto getCategoryReadDto() {
        return categoryReadDto;
    }

    public void setCategoryReadDto(CategoryReadDto categoryReadDto) {
        this.categoryReadDto = categoryReadDto;
    }
}
