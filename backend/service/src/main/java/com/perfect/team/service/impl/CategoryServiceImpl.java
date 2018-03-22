package com.perfect.team.service.impl;

import com.perfect.team.service.api.CategoryService;
import com.perfect.team.service.request.CategoryCreateRequest;
import com.perfect.team.service.request.CategoryUpdateRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.CategoryResponse;

import java.net.URI;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public URI create(CategoryCreateRequest request) {
        return null;
    }

    @Override
    public CategoryResponse read(Long id) {
        return null;
    }

    @Override
    public CategoryResponse update(Long id, CategoryUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CategoriesResponse readAll() {
        return null;
    }
}
