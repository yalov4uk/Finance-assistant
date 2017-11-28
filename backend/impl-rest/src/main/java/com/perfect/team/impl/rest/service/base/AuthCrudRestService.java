package com.perfect.team.impl.rest.service.base;

import java.util.List;

public interface AuthCrudRestService<Request, Response, ListResponse> extends CrudRestService<Request, Response, ListResponse> {

    ListResponse readAllByUserId(Long userId);
}
