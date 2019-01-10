package com.perfect.team.rest.impl.resource;

import com.perfect.team.business.service.ConfirmationService;
import com.perfect.team.common.api.ConfirmationResource;
import com.perfect.team.common.api.UserResource;
import com.perfect.team.common.model.Confirmation;
import com.perfect.team.common.request.ConfirmationCreateRequest;
import com.perfect.team.common.request.ConfirmationRequest;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;

@Singleton
public class ConfirmationResourceImpl implements ConfirmationResource {

  @Inject
  private ConfirmationService service;

  @Inject
  private Mapper mapper;

  @Override
  public Response create(ConfirmationCreateRequest request) {
    Confirmation bean = mapper.map(request, Confirmation.class);
    service.create(bean);
    return Response.noContent().build();
  }

  @Override
  public Response confirm(Long id, ConfirmationRequest request) {
    Confirmation bean = mapper.map(request, Confirmation.class);
    bean.setId(id);
    service.confirm(bean);
    URI location = UriBuilder.fromResource(UserResource.class)
        .path(bean.getUser().getId().toString()).build();
    return Response.seeOther(location).build();
  }
}