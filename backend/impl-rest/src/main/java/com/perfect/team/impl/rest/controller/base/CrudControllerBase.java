package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

public abstract class CrudControllerBase<Request, Response, ListResponse> implements CrudController<Request, Response> {

    protected abstract CrudRestService<Request, Response, ListResponse> getCrudRestService();

    @Override
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Response> create(Request request) {
        return ResponseEntity.ok(getCrudRestService().create(request));
    }

    @Override
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> read(Long id) {
        return ResponseEntity.ok(getCrudRestService().read(id));
    }

    @Override
    //@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(Long id, Request bean) {
        return ResponseEntity.ok(getCrudRestService().update(id, bean));
    }

    @Override
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiResponses(@ApiResponse(message = "hello", code = 204))
    public ResponseEntity delete(Long id) {
        getCrudRestService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
