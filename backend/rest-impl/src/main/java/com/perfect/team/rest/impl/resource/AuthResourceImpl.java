package com.perfect.team.rest.impl.resource;

import com.perfect.team.rest.api.request.SignInRq;
import com.perfect.team.rest.api.request.SignUpRq;
import com.perfect.team.rest.api.resource.AuthResource;
import com.perfect.team.rest.api.response.AuthRs;
import com.perfect.team.rest.api.response.UserRs;
import com.perfect.team.rest.impl.helper.RequestHelper;
import com.perfect.team.service.api.AuthService;
import com.perfect.team.service.request.SignInRequest;
import com.perfect.team.service.request.SignUpRequest;
import com.perfect.team.service.response.AuthResponse;
import com.perfect.team.service.response.UserResponse;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Singleton
public class AuthResourceImpl implements AuthResource {

  @Inject
  private AuthService service;

  @Inject
  private ModelMapper mapper;

  @Inject
  private RequestHelper requestHelper;

  @Override
  public Response signUp(SignUpRq request, HttpHeaders headers) {
    SignUpRequest signUpRequest = mapper.map(request, SignUpRequest.class);
    requestHelper.prepareRequest(signUpRequest, headers);
    UserResponse response = service.signUp(signUpRequest);
    return Response.ok(mapper.map(response, UserRs.class)).build();
  }

  @Override
  public Response signIn(SignInRq request, String method, HttpHeaders headers) {
    SignInRequest signInRequest = mapper.map(request, SignInRequest.class);
    mapper.map(method, signInRequest);
    requestHelper.prepareRequest(signInRequest, headers);
    AuthResponse response = service.signIn(signInRequest);
    return Response.ok(mapper.map(response, AuthRs.class)).build();
  }
}
