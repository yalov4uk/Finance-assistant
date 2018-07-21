package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.TransactionCreateRequest;
import com.perfect.team.api.request.TransactionReadRequest;
import com.perfect.team.api.request.TransactionUpdateRequest;
import com.perfect.team.api.response.TransactionResponse;
import com.perfect.team.api.response.TransactionsResponse;
import com.perfect.team.api.rest.TransactionResource;
import com.perfect.team.common.model.Transaction;
import com.perfect.team.business.service.TransactionService;
import com.perfect.team.rest.impl.model.CollectionWrapper;
import java.net.URI;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;

public class TransactionResourceImpl implements TransactionResource {

  @Inject
  private TransactionService service;

  @Inject
  private Mapper mapper;

  @Override
  public Response create(TransactionCreateRequest request) {
    Transaction bean = mapper.map(request, Transaction.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(TransactionResource.class).path(beanId.toString())
        .build();
    return Response.created(location).build();
  }

  @Override
  public Response read(TransactionReadRequest request) {
    CollectionWrapper<Transaction> beans = new CollectionWrapper<>(service
        .read(request.getId(), request.getDate() == null ? null : mapper.map(request.getDate(),
            Date.class), request.getCategoryId(), request.getAccountId(), request.getUserId()));
    return Response.ok(mapper.map(beans, TransactionsResponse.class)).build();
  }

  @Override
  public Response update(Long id, TransactionUpdateRequest request) {
    Transaction bean = mapper.map(request, Transaction.class);
    bean.setId(id);
    bean = service.update(bean);
    return Response.ok(mapper.map(bean, TransactionResponse.class)).build();
  }

  @Override
  public Response delete(Long id) {
    service.delete(id);
    return Response.noContent().build();
  }
}