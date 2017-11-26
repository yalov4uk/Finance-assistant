package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.AccountController;
import com.perfect.team.api.rest.request.AccountRequest;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.service.AccountRestService;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountControllerImpl implements AccountController {

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

    @RequestMapping(path = "/{id}/", method = RequestMethod.GET)
    public HttpEntity getById(@PathVariable("id") Long id) {
        return new HttpEntity<>(accountRestService.findById(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HttpEntity update(@RequestBody AccountRequest accountRequest) {
        if (accountRequest.getAccountDto().getId() != null) {
            return new HttpEntity<>(accountRestService.save(accountRequest));
        } else {
            return new HttpEntity<>("Please add id");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity add(@RequestBody AccountRequest accountRequest) {
        if (accountRequest.getAccountDto().getId() == null) {
            return new HttpEntity<>(accountRestService.save(accountRequest));
        } else {
            return new HttpEntity<>("Can't post with id");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpEntity delete(@RequestBody AccountRequest accountRequest) {
        if (accountRequest.getAccountDto().getId() != null) {
            accountRestService.delete(accountRequest);
            return new HttpEntity<>("ok");
        } else {
            return new HttpEntity<>("Please add id");
        }
    }
}