package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.TransferController;
import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.api.rest.response.entity.TransferResponse;
import com.perfect.team.api.rest.response.entity.TransfersResponse;
import com.perfect.team.impl.rest.controller.base.AuthCrudControllerBase;
import com.perfect.team.impl.rest.service.TransferRestService;
import com.perfect.team.impl.rest.service.base.AuthCrudRestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(
        value = "api/v1/transfers",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class TransferControllerImpl extends AuthCrudControllerBase<TransferRequest, TransferResponse, TransfersResponse>
        implements TransferController {

    @Inject
    private TransferRestService transferRestService;

    @Override
    protected AuthCrudRestService<TransferRequest, TransferResponse, TransfersResponse> getCrudRestService() {
        return transferRestService;
    }
}