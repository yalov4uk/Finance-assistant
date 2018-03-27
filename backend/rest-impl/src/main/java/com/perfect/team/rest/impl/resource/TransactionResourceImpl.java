package com.perfect.team.rest.impl.resource;

import com.perfect.team.rest.api.request.TransactionCreateRq;
import com.perfect.team.rest.api.request.TransactionUpdateRq;
import com.perfect.team.rest.api.resource.TransactionResource;
import com.perfect.team.rest.api.response.TransactionRs;
import com.perfect.team.rest.api.response.TransactionsRs;
import com.perfect.team.rest.impl.helper.RequestHelper;
import com.perfect.team.service.api.TransactionService;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.TransactionCreateRequest;
import com.perfect.team.service.request.TransactionUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.TransactionResponse;
import com.perfect.team.service.response.TransactionsResponse;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

public class TransactionResourceImpl implements TransactionResource {

  @Inject
  private TransactionService service;

  @Inject
  private ModelMapper mapper;

  @Inject
  private RequestHelper requestHelper;

  @Override
  public Response create(TransactionCreateRq request, HttpHeaders headers) {
    TransactionCreateRequest createRequest = mapper.map(request, TransactionCreateRequest.class);
    requestHelper.prepareRequest(createRequest, headers);
    URI location = service.create(createRequest);
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id, HttpHeaders headers) {
    IdRequest idRequest = mapper.map(id, IdRequest.class);
    requestHelper.prepareRequest(idRequest, headers);
    TransactionResponse response = service.read(idRequest);
    return Response.ok(mapper.map(response, TransactionRs.class)).build();
  }

  @Override
  public Response update(Long id, TransactionUpdateRq request, HttpHeaders headers) {
    TransactionUpdateRequest updateRequest = mapper.map(request, TransactionUpdateRequest.class);
    mapper.map(id, updateRequest);
    requestHelper.prepareRequest(updateRequest, headers);
    TransactionResponse response = service.update(updateRequest);
    return Response.ok(mapper.map(response, TransactionRs.class)).build();
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
    TransactionsResponse response = service.readAll(authRequest);
    return Response.ok(mapper.map(response, TransactionsRs.class)).build();
  }
}