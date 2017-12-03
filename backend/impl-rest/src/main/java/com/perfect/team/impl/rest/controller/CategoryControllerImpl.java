package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.CategoryController;
import com.perfect.team.api.rest.request.entity.CategoryRequest;
import com.perfect.team.impl.rest.controller.base.CrudControllerBase;
import com.perfect.team.impl.rest.service.CategoryRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

@Controller
public class CategoryControllerImpl extends CrudControllerBase<CategoryRequest> implements CategoryController {

    @Inject
    private CategoryRestService categoryRestService;

    @Override
    protected CrudRestService getService() {
        return categoryRestService;
    }
}