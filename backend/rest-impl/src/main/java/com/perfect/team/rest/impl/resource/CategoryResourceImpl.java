package com.perfect.team.rest.impl.resource;

import com.perfect.team.rest.api.request.CategoryCreateRq;
import com.perfect.team.rest.api.request.CategoryUpdateRq;
import com.perfect.team.rest.api.resource.CategoryResource;
import com.perfect.team.rest.api.response.CategoriesRs;
import com.perfect.team.rest.api.response.CategoryRs;
import com.perfect.team.rest.impl.helper.RequestHelper;
import com.perfect.team.service.api.CategoryService;
import com.perfect.team.service.request.CategoryCreateRequest;
import com.perfect.team.service.request.CategoryUpdateRequest;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.CategoryResponse;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Singleton
public class CategoryResourceImpl implements CategoryResource {

  @Inject
  private CategoryService service;

  @Inject
  private ModelMapper mapper;

  @Inject
  private RequestHelper requestHelper;

  @Override
  public Response create(CategoryCreateRq request, HttpHeaders headers) {
    CategoryCreateRequest createRequest = mapper.map(request, CategoryCreateRequest.class);
    requestHelper.prepareRequest(createRequest, headers);
    URI location = service.create(createRequest);
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id, HttpHeaders headers) {
    IdRequest idRequest = mapper.map(id, IdRequest.class);
    requestHelper.prepareRequest(idRequest, headers);
    CategoryResponse response = service.read(idRequest);
    return Response.ok(mapper.map(response, CategoryRs.class)).build();
  }

  @Override
  public Response update(Long id, CategoryUpdateRq request, HttpHeaders headers) {
    CategoryUpdateRequest updateRequest = mapper.map(request, CategoryUpdateRequest.class);
    mapper.map(id, updateRequest);
    requestHelper.prepareRequest(updateRequest, headers);
    CategoryResponse response = service.update(updateRequest);
    return Response.ok(mapper.map(response, CategoryRs.class)).build();
  }

  @Override
  public Response delete(Long id, HttpHeaders headers) {
    IdRequest idRequest = mapper.map(id, IdRequest.class);
    requestHelper.prepareRequest(idRequest, headers);
    service.delete(idRequest);
    return Response.noContent().build();
  }

  @Override
  public Response readAll(HttpHeaders headers) {
    AuthRequest authRequest = new AuthRequest();
    requestHelper.prepareRequest(authRequest, headers);
    CategoriesResponse response = service.readAll(authRequest);
    return Response.ok(mapper.map(response, CategoriesRs.class)).build();
  }
}