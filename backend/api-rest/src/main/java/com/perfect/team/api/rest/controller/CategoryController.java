package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.api.rest.request.entity.CategoryRequest;
import com.perfect.team.api.rest.response.entity.CategoriesResponse;
import com.perfect.team.api.rest.response.entity.CategoryResponse;

/**
 * Created by Denis on 26.11.2017.
 */
public interface CategoryController extends AuthCrudController<CategoryRequest, CategoryResponse, CategoriesResponse> {
}
