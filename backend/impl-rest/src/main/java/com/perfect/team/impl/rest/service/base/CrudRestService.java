package com.perfect.team.impl.rest.service.base;

import java.net.URI;

public interface CrudRestService<Request, Response, ListResponse> {

    URI create(Request request);

    Response read(Long id);

    Response update(Long id, Request request);

    void delete(Long id);

    ListResponse readAll();
}
