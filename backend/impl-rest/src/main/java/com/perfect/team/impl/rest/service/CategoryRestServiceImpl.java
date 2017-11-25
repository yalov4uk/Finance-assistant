package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.CategoryDto;
import com.perfect.team.api.rest.model.entity.UserDto;
import com.perfect.team.api.rest.request.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.service.CategoryService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class CategoryRestServiceImpl extends CrudRestServiceImpl implements CategoryRestService {
    @Inject
    private CategoryService categoryService;

    @Override
    public CategoriesResponse findByUserId(Long id) {
        List<Category> categories = categoryService.findByUserId(id);
        CategoriesResponse categoryResponse = new CategoriesResponse();
        categoryResponse.setCategoryDtos(categories
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList()));
        return categoryResponse;
    }

    @Override
    public CategoryResponse findById(Long id) {
        Category category = categoryService.findById(id);
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryDto(modelMapper.map(category, CategoryDto.class));
        return categoryResponse;
    }
    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        Category category = modelMapper.map(categoryRequest.getCategoryDto(), Category.class);
        category = categoryService.save(category);
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryDto(modelMapper.map(category, CategoryDto.class));
        return categoryResponse;
    }

    @Override
    public void delete(CategoryRequest categoryRequest){
        Category category = modelMapper.map(categoryRequest.getCategoryDto(), Category.class);
        categoryService.delete(category.getId());
    }
}
