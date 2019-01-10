package com.perfect.team.rest.impl.resource;

import com.perfect.team.business.service.AccountService;
import com.perfect.team.common.api.AccountResource;
import com.perfect.team.common.model.Account;
import com.perfect.team.common.model.Account.Currency;
import com.perfect.team.common.request.AccountCreateRequest;
import com.perfect.team.common.request.AccountReadRequest;
import com.perfect.team.common.request.AccountUpdateRequest;
import com.perfect.team.common.response.AccountResponse;
import com.perfect.team.common.response.AccountsResponse;
import com.perfect.team.common.util.CollectionWrapper;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;

@Singleton
public class AccountResourceImpl implements AccountResource {

  @Inject
  private AccountService service;

  @Inject
  private Mapper mapper;

  @Override
  public Response create(AccountCreateRequest request) {
    Account bean = mapper.map(request, Account.class);
    Long beanId = service.create(bean);
    URI location = UriBuilder.fromResource(AccountResource.class).path(beanId.toString()).build();
    return Response.created(location).build();
  }

  @Override
  public Response read(AccountReadRequest request) {
    CollectionWrapper<Account> beans = new CollectionWrapper<>(service
        .read(request.getId(), request.getName(),
            request.getCurrency() == null ? null : mapper.map(request,
                Currency.class), request.getUserId()));
    return Response.ok(mapper.map(beans, AccountsResponse.class)).build();
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
}
