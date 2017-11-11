package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.UserRequest;
import com.perfect.team.impl.rest.service.AuthRestService;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(
        value = "api/v1/auth",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AuthControllerImpl {

    @Inject
    private AuthRestService authRestService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public HttpEntity signUp(@RequestBody UserRequest userRequest) {
        return new HttpEntity<>(authRestService.signUp(userRequest));
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public HttpEntity signIn(@RequestBody SignInRequest signInRequest) {
        return new HttpEntity<>(authRestService.signIn(signInRequest));
    }
}
