package com.perfect.team.service.api;

import com.perfect.team.service.request.CategoryCreateRequest;
import com.perfect.team.service.request.CategoryUpdateRequest;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.CategoryResponse;
import com.perfect.team.service.validation.CategoryCreate;
import com.perfect.team.service.validation.CategoryId;
import com.perfect.team.service.validation.CategoryUpdate;
import java.net.URI;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryService {

  URI create(@CategoryCreate CategoryCreateRequest request);

  CategoryResponse read(@CategoryId IdRequest request);

  CategoryResponse update(@CategoryUpdate CategoryUpdateRequest request);

  void delete(@CategoryId IdRequest request);

  CategoriesResponse readAll(AuthRequest request);
}