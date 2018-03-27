package com.perfect.team.service.impl;

import com.perfect.team.service.api.CategoryService;
import com.perfect.team.service.request.CategoryCreateRequest;
import com.perfect.team.service.request.CategoryUpdateRequest;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.CategoryResponse;
import java.net.URI;
import org.springframework.stereotype.Service;

@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

  @Override
  public URI create(CategoryCreateRequest request) {
    return null;
  }

  @Override
  public CategoryResponse read(IdRequest request) {
    return null;
  }

  @Override
  public CategoryResponse update(CategoryUpdateRequest request) {
    return null;
  }

  @Override
  public void delete(IdRequest request) {

  }

  @Override
  public CategoriesResponse readAll(AuthRequest request) {
    return null;
  }
}
