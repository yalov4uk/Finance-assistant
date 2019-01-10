package com.perfect.team.rest.impl.resource;

import com.perfect.team.business.service.UserService;
import com.perfect.team.common.api.UserResource;
import com.perfect.team.common.model.User;
import com.perfect.team.common.request.UserCreateRequest;
import com.perfect.team.common.request.UserReadRequest;
import com.perfect.team.common.request.UserUpdateRequest;
import com.perfect.team.common.response.UserResponse;
import com.perfect.team.common.response.UsersResponse;
import com.perfect.team.common.util.CollectionWrapper;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;

public class UserResourceImpl implements UserResource {

  @Inject
  private UserService service;

  @Inject
  private Mapper mapper;

  @Override
  public Response create(UserCreateRequest request) {
    User bean = mapper.map(request, User.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(UserResource.class).path(beanId.toString())
        .build();
    return Response.created(location).build();
  }

  @Override
  public Response read(UserReadRequest request) {
    CollectionWrapper<User> beans = new CollectionWrapper<>(
        service.read(request.getId(), request.getName()));
    return Response.ok(mapper.map(beans, UsersResponse.class)).build();
  }

  @Override
  public Response update(Long id, UserUpdateRequest request) {
    User bean = mapper.map(request, User.class);
    bean.setId(id);
    bean = service.update(bean);
    return Response.ok(mapper.map(bean, UserResponse.class)).build();
  }

  @Override
  public Response delete(Long id) {
    service.delete(id);
    return Response.noContent().build();
  }
}