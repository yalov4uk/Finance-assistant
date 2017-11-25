package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.AccountRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Denis on 26.11.2017.
 */
public interface AccountController {
    HttpEntity getAllAccounts();
    HttpEntity getById(@PathVariable("id") Long id);
    HttpEntity update(@RequestBody AccountRequest accountRequest);
    HttpEntity add(@RequestBody AccountRequest accountRequest);
    HttpEntity delete(@RequestBody AccountRequest accountRequest);
}
