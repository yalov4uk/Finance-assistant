package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.CategoryDto;
import com.perfect.team.api.rest.request.entity.CategoryRequest;
import com.perfect.team.api.rest.response.entity.CategoriesResponse;
import com.perfect.team.api.rest.response.entity.CategoryResponse;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.service.CategoryService;
import com.perfect.team.business.service.base.AuthCrudService;
import com.perfect.team.business.service.base.CrudService;
import com.perfect.team.impl.rest.service.base.AuthCrudRestServiceBase;
import com.perfect.team.impl.rest.service.base.CrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
@Transactional
public class CategoryRestServiceImpl
        extends AuthCrudRestServiceBase<CategoryRequest, Category, CategoryResponse, CategoriesResponse>
        implements CategoryRestService {

    @Inject
    private CategoryService categoryService;

    @Override
    protected AuthCrudService<Category> getCrudService() {
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
