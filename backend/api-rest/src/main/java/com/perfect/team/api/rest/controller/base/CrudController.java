package com.perfect.team.api.rest.controller.base;

import org.springframework.http.ResponseEntity;

public interface CrudController<Request> {

    ResponseEntity create(Request request);

    ResponseEntity read(Long id);

    ResponseEntity update(Long id, Request bean);

    ResponseEntity delete(Long id);

    ResponseEntity readAll();
}
