package com.perfect.team.api.rest.controller.base;

import org.springframework.http.ResponseEntity;

public interface AuthCrudController<Request> extends CrudController<Request> {

    ResponseEntity readAllByUserId();
}
