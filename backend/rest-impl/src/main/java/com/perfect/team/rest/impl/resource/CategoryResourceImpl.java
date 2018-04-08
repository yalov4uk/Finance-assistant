package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.CategoryCreateRequest;
import com.perfect.team.api.request.CategoryUpdateRequest;
import com.perfect.team.api.response.CategoriesResponse;
import com.perfect.team.api.response.CategoryResponse;
import com.perfect.team.api.rest.CategoryResource;
import com.perfect.team.business.model.Category;
import com.perfect.team.business.service.CategoryService;
import com.perfect.team.rest.impl.model.CollectionWrapper;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.DozerBeanMapper;

@Singleton
public class CategoryResourceImpl implements CategoryResource {

  @Inject
  private CategoryService service;

  @Inject
  private DozerBeanMapper mapper;

  @Override
  public Response create(CategoryCreateRequest request) {
    Category bean = mapper.map(request, Category.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(CategoryResource.class).path(beanId.toString()).build();
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id) {
    Category bean = service.read(id);
    return Response.ok(mapper.map(bean, CategoryResponse.class)).build();
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

  @Override
  public Response readAll() {
    CollectionWrapper<Category> beans = new CollectionWrapper<>(service.readAll());
    return Response.ok(mapper.map(beans, CategoriesResponse.class)).build();
  }
}