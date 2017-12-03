package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.UserController;
import com.perfect.team.api.rest.request.entity.UserRequest;
import com.perfect.team.impl.rest.controller.base.CrudControllerBase;
import com.perfect.team.impl.rest.service.UserRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;


@Controller
public class UserControllerImpl extends CrudControllerBase<UserRequest> implements UserController {

    @Inject
    private UserRestService userRestService;

    @Override
    protected CrudRestService getService() {
        return userRestService;
    }
}