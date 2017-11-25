package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.model.entity.AccountDto;
import com.perfect.team.api.rest.request.AccountRequest;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.service.AccountRestService;
import com.perfect.team.impl.rest.service.UserRestService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {

    @Inject
    private AccountRestService accountRestService;

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAllAccounts() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User currentUser = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            return new HttpEntity<>(accountRestService.findByUserId(currentUser.getId()));
        } else {
            return new HttpEntity<>("No auth");
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity add(@RequestBody AccountRequest accountRequest) {
        return new HttpEntity<>(accountRestService.save(accountRequest));
    }
}