package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class CrudControllerBase<Request, Response, ListResponse> implements CrudController<Request> {

    protected abstract CrudRestService<Request, Response, ListResponse> getCrudRestService();

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Request request) {
        return ResponseEntity.ok(getCrudRestService().create(request));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity read(@PathVariable Long id) {
        return ResponseEntity.ok(getCrudRestService().read(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody Request bean) {
        return ResponseEntity.ok(getCrudRestService().update(id, bean));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        getCrudRestService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
