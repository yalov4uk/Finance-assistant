package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.CategoryRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Denis on 26.11.2017.
 */
public interface CategoryController {
    HttpEntity getAllCategorys();
    HttpEntity getById(@PathVariable("id") Long id);
    HttpEntity update(@RequestBody CategoryRequest categoryRequest);
    HttpEntity add(@RequestBody CategoryRequest categoryRequest);
    HttpEntity delete(@RequestBody CategoryRequest categoryRequest);
}
