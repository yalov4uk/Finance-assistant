package com.perfect.team.rest.impl.resource;

import com.perfect.team.rest.api.request.UserUpdateRq;
import com.perfect.team.rest.api.resource.UserResource;
import com.perfect.team.rest.api.response.UserRs;
import com.perfect.team.rest.api.response.UsersRs;
import com.perfect.team.rest.impl.helper.RequestHelper;
import com.perfect.team.service.api.UserService;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.UserUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.UserResponse;
import com.perfect.team.service.response.UsersResponse;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

public class UserResourceImpl implements UserResource {

  @Inject
  private UserService service;

  @Inject
  private ModelMapper mapper;

  @Inject
  private RequestHelper requestHelper;

  @Override
  public Response read(Long id, HttpHeaders headers) {
    IdRequest idRequest = mapper.map(id, IdRequest.class);
    requestHelper.prepareRequest(idRequest, headers);
    UserResponse response = service.read(idRequest);
    return Response.ok(mapper.map(response, UserRs.class)).build();
  }

  @Override
  public Response update(Long id, UserUpdateRq request, HttpHeaders headers) {
    UserUpdateRequest updateRequest = mapper.map(request, UserUpdateRequest.class);
    mapper.map(id, updateRequest);
    requestHelper.prepareRequest(updateRequest, headers);
    UserResponse response = service.update(updateRequest);
    return Response.ok(mapper.map(response, UserRs.class)).build();
  }

  @Override
  public Response readAll(HttpHeaders headers) {
    AuthRequest authRequest = new AuthRequest();
    requestHelper.prepareRequest(authRequest, headers);
    UsersResponse response = service.readAll(authRequest);
    return Response.ok(mapper.map(response, UsersRs.class)).build();
  }
}