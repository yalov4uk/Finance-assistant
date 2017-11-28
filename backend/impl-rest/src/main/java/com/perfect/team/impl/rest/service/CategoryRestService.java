package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.CategoryRequest;
import com.perfect.team.api.rest.response.entity.CategoriesResponse;
import com.perfect.team.api.rest.response.entity.CategoryResponse;
import com.perfect.team.impl.rest.service.base.AuthCrudRestService;


/**
 * Created by Denis on 25.11.2017.
 */
public interface CategoryRestService
        extends AuthCrudRestService<CategoryRequest, CategoryResponse, CategoriesResponse> {
}
