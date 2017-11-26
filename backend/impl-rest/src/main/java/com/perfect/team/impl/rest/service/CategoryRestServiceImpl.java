package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.CategoryDto;
import com.perfect.team.api.rest.request.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.service.CategoryService;
import com.perfect.team.business.service.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class CategoryRestServiceImpl
        extends CrudRestServiceImpl<CategoryRequest, Category, CategoryResponse, CategoriesResponse>
        implements CategoryRestService {

    @Inject
    private CategoryService categoryService;

    @Override
    public CategoriesResponse readByUserId(Long userId) {
        List<Category> categories = categoryService.readByUserId(userId);
        return mapEntitiesToListResponse(categories);
    }

    @Override
    protected CrudService<Category> getCrudService() {
        return categoryService;
    }

    @Override
    protected Category mapRequestToEntity(CategoryRequest categoryRequest) {
        return modelMapper.map(categoryRequest.getCategoryDto(), Category.class);
    }

    @Override
    protected CategoryResponse mapEntityToResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryDto(modelMapper.map(category, CategoryDto.class));
        return categoryResponse;
    }

    @Override
    protected CategoriesResponse mapEntitiesToListResponse(List<Category> categories) {
        CategoriesResponse categoriesResponse = new CategoriesResponse();
        categoriesResponse.setCategoryDtos(categories
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList()));
        return categoriesResponse;
    }
}
