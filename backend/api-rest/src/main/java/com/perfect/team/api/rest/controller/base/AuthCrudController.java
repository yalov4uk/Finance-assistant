package com.perfect.team.api.rest.controller.base;

import org.springframework.http.ResponseEntity;

public interface AuthCrudController<Request, Response, ListResponse> extends CrudController<Request, Response> {

    ResponseEntity<ListResponse> readAllByUserId();
}
