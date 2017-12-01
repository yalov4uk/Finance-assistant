package com.perfect.team.api.rest.controller.base;

import org.springframework.http.ResponseEntity;

public interface CrudController<Request, Response> {

    ResponseEntity<Response> create(Request request);

    ResponseEntity<Response> read(Long id);

    ResponseEntity<Response> update(Long id, Request bean);

    ResponseEntity delete(Long id);
}
