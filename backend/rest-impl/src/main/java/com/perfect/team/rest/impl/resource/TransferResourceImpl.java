package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.TransferCreateRequest;
import com.perfect.team.api.request.TransferReadRequest;
import com.perfect.team.api.request.TransferUpdateRequest;
import com.perfect.team.api.response.TransferResponse;
import com.perfect.team.api.response.TransfersResponse;
import com.perfect.team.api.rest.TransferResource;
import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.service.TransferService;
import com.perfect.team.rest.impl.model.CollectionWrapper;
import java.net.URI;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;

public class TransferResourceImpl implements TransferResource {

  @Inject
  private TransferService service;

  @Inject
  private Mapper mapper;

  @Override
  public Response create(TransferCreateRequest request) {
    Transfer bean = mapper.map(request, Transfer.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(TransferResource.class).path(beanId.toString())
        .build();
    return Response.created(location).build();
  }

  @Override
  public Response read(TransferReadRequest request) {
    CollectionWrapper<Transfer> beans = new CollectionWrapper<>(
        service.read(request.getId(),
            request.getDate() == null ? null : mapper.map(request.getDate(), Date.class),
            request.getFromAccountId(), request.getToAccountId(), request.getUserId()));
    return Response.ok(mapper.map(beans, TransfersResponse.class)).build();
  }

  @Override
  public Response update(Long id, TransferUpdateRequest request) {
    Transfer bean = mapper.map(request, Transfer.class);
    bean.setId(id);
    bean = service.update(bean);
    return Response.ok(mapper.map(bean, TransferResponse.class)).build();
  }

  @Override
  public Response delete(Long id) {
    service.delete(id);
    return Response.noContent().build();
  }
}
