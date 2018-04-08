package com.perfect.team.rest.impl.resource;

import com.perfect.team.api.request.AccountCreateRequest;
import com.perfect.team.api.request.AccountUpdateRequest;
import com.perfect.team.api.response.AccountResponse;
import com.perfect.team.api.response.AccountsResponse;
import com.perfect.team.api.rest.AccountResource;
import com.perfect.team.business.model.Account;
import com.perfect.team.business.service.AccountService;
import com.perfect.team.rest.impl.model.CollectionWrapper;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.DozerBeanMapper;

@Singleton
public class AccountResourceImpl implements AccountResource {

  @Inject
  private AccountService service;

  @Inject
  private DozerBeanMapper mapper;

  @Override
  public Response create(AccountCreateRequest request) {
    Account bean = mapper.map(request, Account.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(AccountResource.class).path(beanId.toString()).build();
    return Response.created(location).build();
  }

  @Override
  public Response read(Long id) {
    Account bean = service.read(id);
    return Response.ok(mapper.map(bean, AccountResponse.class)).build();
  }

  @Override
  public Response update(Long id, AccountUpdateRequest request) {
    Account bean = mapper.map(request, Account.class);
    bean.setId(id);
    bean = service.update(bean);
    return Response.ok(mapper.map(bean, AccountResponse.class)).build();
  }

  @Override
  public Response delete(Long id) {
    service.delete(id);
    return Response.noContent().build();
  }

  @Override
  public Response readAll() {
    CollectionWrapper<Account> beans = new CollectionWrapper<>(service.readAll());
    return Response.ok(mapper.map(beans, AccountsResponse.class)).build();
  }
}
