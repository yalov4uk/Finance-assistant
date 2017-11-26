package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.impl.rest.service.base.AuthCrudRestService;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AuthCrudControllerImpl<Request> implements AuthCrudController<Request> {

    protected abstract AuthCrudRestService getAuthCrudRestService();

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity create(@RequestBody Request request, @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity read(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpEntity update(@PathVariable Long id, @RequestBody Request bean,
                             @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpEntity delete(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity readAll(@AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }
}
