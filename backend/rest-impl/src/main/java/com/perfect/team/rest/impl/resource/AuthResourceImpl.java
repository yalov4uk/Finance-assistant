package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.SignInRequest;
import com.perfect.team.api.request.SignUpRequest;
import com.perfect.team.api.response.SignInResponse;
import com.perfect.team.api.response.SignUpResponse;
import com.perfect.team.api.rest.AuthResource;
import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.model.AuthUser;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.AuthService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import org.dozer.DozerBeanMapper;

@Singleton
public class AuthResourceImpl implements AuthResource {

  @Inject
  private AuthService service;

  @Inject
  private DozerBeanMapper mapper;

  @Override
  public Response signUp(SignUpRequest request) {
    User bean = mapper.map(request, User.class);
    bean = service.signUp(bean);
    SignUpResponse response = mapper.map(bean, SignUpResponse.class);
    return Response.ok(response).build();
  }

  @Override
  public Response signIn(SignInRequest request) {
    AuthUser authUser = service
        .signIn(request.getSignInDto().getEmail(), request.getSignInDto().getPassword());
    SignInResponse response = mapper.map(authUser, SignInResponse.class);
    return Response.ok(response).build();
  }

  @Override
  public Response signInWith(String token, String method) {
    AuthUser authUser = service.signInWith(token, AuthMethod.valueOf(method.toUpperCase()));
    SignInResponse response = mapper.map(authUser, SignInResponse.class);
    return Response.ok(response).build();
  }
}
