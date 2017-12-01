package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.AuthController;
import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import com.perfect.team.impl.rest.service.AuthRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class AuthControllerImpl implements AuthController {

    @Inject
    private AuthRestService authRestService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse>  signUp(@RequestBody SignUpRequest signUpRequest) {
        return new ResponseEntity<>(authRestService.signUp(signUpRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse>  signIn(@RequestBody SignInRequest signInRequest) {
        return new ResponseEntity<>(authRestService.signIn(signInRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/signin/facebook", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse>  signInWithFacebook(@RequestBody TokenRequest tokenRequest) {
        return new ResponseEntity<>(authRestService.signInWithFacebook(tokenRequest), HttpStatus.OK);
    }
}
