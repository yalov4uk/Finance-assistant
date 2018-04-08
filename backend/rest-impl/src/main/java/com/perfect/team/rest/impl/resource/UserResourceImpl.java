package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.UserUpdateRequest;
import com.perfect.team.api.response.UserResponse;
import com.perfect.team.api.response.UsersResponse;
import com.perfect.team.api.rest.UserResource;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.rest.impl.model.CollectionWrapper;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.dozer.DozerBeanMapper;

public class UserResourceImpl implements UserResource {

  @Inject
  private UserService service;

  @Inject
  private DozerBeanMapper mapper;

  @Override
  public Response read(Long id) {
    User bean = service.read(id);
    return Response.ok(mapper.map(bean, UserResponse.class)).build();
  }

  @Override
  public Response update(Long id, UserUpdateRequest request) {
    User bean = mapper.map(request, User.class);
    bean.setId(id);
    bean = service.update(bean);
    return Response.ok(mapper.map(bean, UserResponse.class)).build();
  }

  @Override
  public Response readAll() {
    CollectionWrapper<User> beans = new CollectionWrapper<>(service.readAll());
    return Response.ok(mapper.map(beans, UsersResponse.class)).build();
  }
}