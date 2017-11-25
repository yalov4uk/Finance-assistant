package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.CategoryDto;
import com.perfect.team.api.rest.request.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;


/**
 * Created by Denis on 25.11.2017.
 */
public interface CategoryRestService {
    CategoriesResponse findByUserId(Long id);
    CategoryResponse findById(Long id);
    CategoryResponse save(CategoryRequest categoryRequest);
    void delete(CategoryRequest categoryRequest);
}
