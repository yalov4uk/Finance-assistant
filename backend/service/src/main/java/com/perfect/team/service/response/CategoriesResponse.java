package com.perfect.team.service.response;


import com.perfect.team.service.dto.CategoryReadDto;
import com.perfect.team.service.response.base.BaseResponse;

import java.util.List;

public class CategoriesResponse extends BaseResponse {
    private List<CategoryReadDto> categoryReadDtos;

    public List<CategoryReadDto> getCategoryReadDtos() {
        return categoryReadDtos;
    }

    public void setCategoryReadDtos(List<CategoryReadDto> categoryReadDtos) {
        this.categoryReadDtos = categoryReadDtos;
    }
}
