package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class CrudControllerImpl<Request, Response, ListResponse> implements CrudController<Request> {

    protected abstract CrudRestService<Request, Response, ListResponse> getCrudRestService();

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Request request) {
        return new ResponseEntity<>(getCrudRestService().create(request), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity read(@PathVariable Long id) {
        return new ResponseEntity<>(getCrudRestService().read(id), HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody Request bean) {
        return new ResponseEntity<>(getCrudRestService().update(id, bean), HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        getCrudRestService().delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readAll() {
        return new ResponseEntity<>(getCrudRestService().readAll(), HttpStatus.OK);
    }
}
