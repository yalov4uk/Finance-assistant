package com.perfect.team.impl.rest.controller;

import com.perfect.team.impl.rest.service.UserRestService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Inject
    private UserRestService userRestService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAllUsers() {
        return new HttpEntity<>(userRestService.findAll());
    }
}