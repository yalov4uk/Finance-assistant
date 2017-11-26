package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.TransferController;
import com.perfect.team.api.rest.request.TransferRequest;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.service.TransferRestService;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(path = "/api/v1/transfers")
public class TransferControllerImpl implements TransferController {

    @Inject
    private TransferRestService transferRestService;

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAllTransfers() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User currentUser = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            return new HttpEntity<>(transferRestService.findByUserId(currentUser.getId()));
        } else {
            return new HttpEntity<>("No auth");
        }

    }

    @RequestMapping(path = "/{id}/", method = RequestMethod.GET)
    public HttpEntity getById(@PathVariable("id") Long id) {
        return new HttpEntity<>(transferRestService.findById(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HttpEntity update(@RequestBody TransferRequest transferRequest) {
        if (transferRequest.getTransferDto().getId() != null) {
            return new HttpEntity<>(transferRestService.save(transferRequest));
        } else {
            return new HttpEntity<>("Please add id");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity add(@RequestBody TransferRequest transferRequest) {
        if (transferRequest.getTransferDto().getId() == null) {
            return new HttpEntity<>(transferRestService.save(transferRequest));
        } else {
            return new HttpEntity<>("Can't post with id");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpEntity delete(@RequestBody TransferRequest transferRequest) {
        if (transferRequest.getTransferDto().getId() != null) {
            transferRestService.delete(transferRequest);
            return new HttpEntity<>("ok");
        } else {
            return new HttpEntity<>("Please add id");
        }
    }
}