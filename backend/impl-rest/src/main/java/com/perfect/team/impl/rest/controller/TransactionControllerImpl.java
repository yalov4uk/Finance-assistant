package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.TransactionController;
import com.perfect.team.api.rest.request.TransactionRequest;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.service.TransactionRestService;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(path = "/api/v1/transactions")
public class TransactionControllerImpl implements TransactionController {

    @Inject
    private TransactionRestService transactionRestService;

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAllTransactions() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User currentUser = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            return new HttpEntity<>(transactionRestService.findByUserId(currentUser.getId()));
        } else {
            return new HttpEntity<>("No auth");
        }

    }

    @RequestMapping(path = "/{id}/", method = RequestMethod.GET)
    public HttpEntity getById(@PathVariable("id") Long id) {
        return new HttpEntity<>(transactionRestService.findById(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HttpEntity update(@RequestBody TransactionRequest transactionRequest) {
        if (transactionRequest.getTransactionDto().getId() != null) {
            return new HttpEntity<>(transactionRestService.save(transactionRequest));
        } else {
            return new HttpEntity<>("Please add id");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity add(@RequestBody TransactionRequest transactionRequest) {
        if (transactionRequest.getTransactionDto().getId() == null) {
            return new HttpEntity<>(transactionRestService.save(transactionRequest));
        } else {
            return new HttpEntity<>("Can't post with id");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpEntity delete(@RequestBody TransactionRequest transactionRequest) {
        if (transactionRequest.getTransactionDto().getId() != null) {
            transactionRestService.delete(transactionRequest);
            return new HttpEntity<>("ok");
        } else {
            return new HttpEntity<>("Please add id");
        }
    }
}