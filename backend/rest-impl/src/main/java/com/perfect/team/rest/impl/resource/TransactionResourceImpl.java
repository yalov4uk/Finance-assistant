package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.TransactionCreateRequest;
import com.perfect.team.api.request.TransactionUpdateRequest;
import com.perfect.team.api.response.TransactionResponse;
import com.perfect.team.api.response.TransactionsResponse;
import com.perfect.team.api.rest.TransactionResource;
import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.service.TransactionService;
import com.perfect.team.rest.impl.model.CollectionWrapper;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.DozerBeanMapper;

public class TransactionResourceImpl implements TransactionResource {

  @Inject
  private TransactionService service;

  @Inject
  private DozerBeanMapper mapper;

  @Override
  public Response create(TransactionCreateRequest request) {
    Transaction bean = mapper.map(request, Transaction.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(TransactionResource.class).path(beanId.toString())
        .build();
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id) {
    Transaction bean = service.read(id);
    return Response.ok(mapper.map(bean, TransactionResponse.class)).build();
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

  @Override
  public Response readAll() {
    CollectionWrapper<Transaction> beans = new CollectionWrapper<>(service.readAll());
    return Response.ok(mapper.map(beans, TransactionsResponse.class)).build();
  }
}