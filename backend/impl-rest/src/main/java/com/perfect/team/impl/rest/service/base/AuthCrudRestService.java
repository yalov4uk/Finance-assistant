package com.perfect.team.impl.rest.service.base;

public interface AuthCrudRestService<Request, Response, ListResponse> extends CrudRestService<Request, Response, ListResponse> {

    ListResponse readAllByUserId();
}
