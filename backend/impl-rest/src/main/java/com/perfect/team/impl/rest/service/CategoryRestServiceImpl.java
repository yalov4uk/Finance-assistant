package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.CategoryReadDto;
import com.perfect.team.api.rest.request.entity.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.service.auth.CategoryAuthService;
import com.perfect.team.business.service.custom.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryRestServiceImpl
        extends CrudRestServiceBase<CategoryRequest, Category, CategoryResponse, CategoriesResponse>
        implements CategoryRestService {

    @Inject
    private CategoryAuthService categoryService;

    @Override
    protected CrudService<Category> getService() {
        return categoryService;
    }

    @Override
    protected Category mapRequestToEntity(CategoryRequest categoryRequest) {
        return modelMapper.map(categoryRequest.getCategoryReadDto(), Category.class);
    }

    @Override
    protected CategoryResponse mapEntityToResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryReadDto(modelMapper.map(category, CategoryReadDto.class));
        return categoryResponse;
    }

    @Override
    protected CategoriesResponse mapEntitiesToListResponse(List<Category> categories) {
        CategoriesResponse categoriesResponse = new CategoriesResponse();
        categoriesResponse.setCategoryReadDtos(categories
                .stream()
                .map(category -> modelMapper.map(category, CategoryReadDto.class))
                .collect(Collectors.toList()));
        return categoriesResponse;
    }

    @Override
    protected String getEntityPath() {
        return "categories/";
    }
}
