package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.TransferController;
import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.impl.rest.controller.base.CrudControllerBase;
import com.perfect.team.impl.rest.service.TransferRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;

import javax.inject.Inject;

public class TransferControllerImpl extends CrudControllerBase<TransferRequest> implements TransferController {

    @Inject
    private TransferRestService transferRestService;

    @Override
    protected CrudRestService getService() {
        return transferRestService;
    }
}
