package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;

public interface CategoryRestService extends CrudRestService<CategoryRequest, CategoryResponse, CategoriesResponse> {
}
