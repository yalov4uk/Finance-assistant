package com.perfect.team.rest.impl.resource;

import com.perfect.team.business.service.CategoryService;
import com.perfect.team.common.api.CategoryResource;
import com.perfect.team.common.model.Category;
import com.perfect.team.common.model.Category.Type;
import com.perfect.team.common.request.CategoryCreateRequest;
import com.perfect.team.common.request.CategoryReadRequest;
import com.perfect.team.common.request.CategoryUpdateRequest;
import com.perfect.team.common.response.CategoriesResponse;
import com.perfect.team.common.response.CategoryResponse;
import com.perfect.team.common.util.CollectionWrapper;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;

@Singleton
public class CategoryResourceImpl implements CategoryResource {

  @Inject
  private CategoryService service;

  @Inject
  private Mapper mapper;

  @Override
  public Response create(CategoryCreateRequest request) {
    Category bean = mapper.map(request, Category.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(CategoryResource.class).path(beanId.toString()).build();
    return Response.created(location).build();
  }

  @Override
  public Response read(CategoryReadRequest request) {
    CollectionWrapper<Category> beans = new CollectionWrapper<>(
        service.read(request.getId(), request.getName(),
            request.getType() == null ? null : mapper.map(request.getType(), Type.class),
            request.getUserId()));
    return Response.ok(mapper.map(beans, CategoriesResponse.class)).build();
  }

  @Override
  public Response update(Long id, CategoryUpdateRequest request) {
    Category bean = mapper.map(request, Category.class);
    bean.setId(id);
    bean = service.update(bean);
    return Response.ok(mapper.map(bean, CategoryResponse.class)).build();
  }

  @Override
  public Response delete(Long id) {
    service.delete(id);
    return Response.noContent().build();
  }
}