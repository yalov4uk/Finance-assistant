package com.perfect.team.impl.rest.service.base;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public interface CrudRestService<Request, Response, ListResponse> {

    URI create(Request request, UriInfo uriInfo);

    Response read(Long id);

    Response update(Long id, Request request);

    void delete(Long id);

    ListResponse readAll();
}
