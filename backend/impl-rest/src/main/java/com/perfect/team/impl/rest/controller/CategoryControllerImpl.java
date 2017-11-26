package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.CategoryController;
import com.perfect.team.api.rest.request.CategoryRequest;
import com.perfect.team.api.rest.response.CategoriesResponse;
import com.perfect.team.api.rest.response.CategoryResponse;
import com.perfect.team.impl.rest.controller.base.CrudControllerImpl;
import com.perfect.team.impl.rest.service.CategoryRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(
        value = "api/v1/categories",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class CategoryControllerImpl extends CrudControllerImpl<CategoryRequest, CategoryResponse, CategoriesResponse>
        implements CategoryController {

    @Inject
    private CategoryRestService categoryRestService;

    @Override
    protected CrudRestService<CategoryRequest, CategoryResponse, CategoriesResponse> getCrudRestService() {
        return categoryRestService;
    }
}