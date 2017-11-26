package com.perfect.team.impl.rest.service.base;

public interface CrudRestService<Request, Response, ListResponse> extends RestService {

    Response create(Request request);

    Response read(Long id);

    Response update(Long id, Request request);

    void delete(Long id);

    ListResponse readAll();
}
