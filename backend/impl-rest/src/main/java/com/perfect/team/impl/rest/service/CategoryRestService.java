package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;


/**
 * Created by Denis on 25.11.2017.
 */
public interface CategoryRestService extends CrudRestService<CategoryRequest, CategoryResponse, CategoriesResponse> {

    CategoriesResponse readByUserId(Long userId);
}
