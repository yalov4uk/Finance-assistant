package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.SignInRequest;
import com.perfect.team.api.response.SignInResponse;
import com.perfect.team.api.rest.AuthResource;
import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.service.AuthService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class AuthResourceImpl implements AuthResource {

  @Inject
  private AuthService service;

  @Override
  public Response signIn(SignInRequest request) {
    String token = service
        .signIn(request.getSignInDto().getEmail(), request.getSignInDto().getPassword());
    SignInResponse response = new SignInResponse(token);
    return Response.ok(response).build();
  }

  @Override
  public Response signInWith(String accessToken, String method) {
    String token = service.signInWith(accessToken, AuthMethod.valueOf(method.toUpperCase()));
    SignInResponse response = new SignInResponse(token);
    return Response.ok(response).build();
  }
}
