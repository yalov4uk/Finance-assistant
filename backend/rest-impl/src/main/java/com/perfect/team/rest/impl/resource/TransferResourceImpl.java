package com.perfect.team.rest.impl.resource;

import com.perfect.team.rest.api.request.TransferCreateRq;
import com.perfect.team.rest.api.request.TransferUpdateRq;
import com.perfect.team.rest.api.resource.TransferResource;
import com.perfect.team.rest.api.response.TransferRs;
import com.perfect.team.rest.api.response.TransfersRs;
import com.perfect.team.rest.impl.helper.RequestHelper;
import com.perfect.team.service.api.TransferService;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.TransferCreateRequest;
import com.perfect.team.service.request.TransferUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.TransferResponse;
import com.perfect.team.service.response.TransfersResponse;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

public class TransferResourceImpl implements TransferResource {

  @Inject
  private TransferService service;

  @Inject
  private ModelMapper mapper;

  @Inject
  private RequestHelper requestHelper;

  @Override
  public Response create(TransferCreateRq request, HttpHeaders headers) {
    TransferCreateRequest createRequest = mapper.map(request, TransferCreateRequest.class);
    requestHelper.prepareRequest(createRequest, headers);
    URI location = service.create(createRequest);
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id, HttpHeaders headers) {
    IdRequest idRequest = mapper.map(id, IdRequest.class);
    requestHelper.prepareRequest(idRequest, headers);
    TransferResponse response = service.read(idRequest);
    return Response.ok(mapper.map(response, TransferRs.class)).build();
  }

  @Override
  public Response update(Long id, TransferUpdateRq request, HttpHeaders headers) {
    TransferUpdateRequest updateRequest = mapper.map(request, TransferUpdateRequest.class);
    mapper.map(id, updateRequest);
    requestHelper.prepareRequest(updateRequest, headers);
    TransferResponse response = service.update(updateRequest);
    return Response.ok(mapper.map(response, TransferRs.class)).build();
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
    TransfersResponse response = service.readAll(authRequest);
    return Response.ok(mapper.map(response, TransfersRs.class)).build();
  }
}
