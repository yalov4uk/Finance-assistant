package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.impl.rest.service.base.AuthCrudRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AuthCrudControllerBase<Request, Response, ListResponse>
        extends CrudControllerBase<Request, Response, ListResponse>
        implements AuthCrudController<Request, Response, ListResponse> {

    protected abstract AuthCrudRestService<Request, Response, ListResponse> getCrudRestService();

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ListResponse> readAllByUserId() {
        return ResponseEntity.ok(getCrudRestService().readAllByUserId());
    }
}
