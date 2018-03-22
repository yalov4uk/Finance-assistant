package com.perfect.team.service.api;

import com.perfect.team.service.request.CategoryCreateRequest;
import com.perfect.team.service.request.CategoryUpdateRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.CategoryResponse;
import com.perfect.team.service.validation.CategoryCreate;
import com.perfect.team.service.validation.CategoryId;
import com.perfect.team.service.validation.CategoryUpdate;
import org.springframework.validation.annotation.Validated;

import java.net.URI;

@Validated
public interface CategoryService {
    URI create(@CategoryCreate CategoryCreateRequest request);

    CategoryResponse read(@CategoryId Long id);

    CategoryResponse update(@CategoryId Long id, @CategoryUpdate CategoryUpdateRequest request);

    void delete(@CategoryId Long id);

    CategoriesResponse readAll();
}
