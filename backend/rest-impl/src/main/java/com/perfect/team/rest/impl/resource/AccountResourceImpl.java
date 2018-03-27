package com.perfect.team.rest.impl.resource;

import com.perfect.team.rest.api.request.AccountCreateRq;
import com.perfect.team.rest.api.request.AccountUpdateRq;
import com.perfect.team.rest.api.resource.AccountResource;
import com.perfect.team.rest.api.response.AccountRs;
import com.perfect.team.rest.api.response.AccountsRs;
import com.perfect.team.rest.impl.helper.RequestHelper;
import com.perfect.team.service.api.AccountService;
import com.perfect.team.service.request.AccountCreateRequest;
import com.perfect.team.service.request.AccountUpdateRequest;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.AccountResponse;
import com.perfect.team.service.response.AccountsResponse;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Singleton
public class AccountResourceImpl implements AccountResource {

  @Inject
  private AccountService service;

  @Inject
  private ModelMapper mapper;

  @Inject
  private RequestHelper requestHelper;

  @Override
  public Response create(AccountCreateRq request, HttpHeaders headers) {
    AccountCreateRequest createRequest = mapper.map(request, AccountCreateRequest.class);
    requestHelper.prepareRequest(createRequest, headers);
    URI location = service.create(createRequest);
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id, HttpHeaders headers) {
    IdRequest idRequest = mapper.map(id, IdRequest.class);
    requestHelper.prepareRequest(idRequest, headers);
    AccountResponse response = service.read(idRequest);
    return Response.ok(mapper.map(response, AccountRs.class)).build();
  }

  @Override
  public Response update(Long id, AccountUpdateRq request, HttpHeaders headers) {
    AccountUpdateRequest updateRequest = mapper.map(request, AccountUpdateRequest.class);
    mapper.map(id, updateRequest);
    requestHelper.prepareRequest(updateRequest, headers);
    AccountResponse response = service.update(updateRequest);
    return Response.ok(mapper.map(response, AccountRs.class)).build();
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
    AccountsResponse response = service.readAll(authRequest);
    return Response.ok(mapper.map(response, AccountsRs.class)).build();
  }
}
