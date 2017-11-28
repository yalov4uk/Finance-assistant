package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.api.rest.response.entity.TransferResponse;
import com.perfect.team.api.rest.response.entity.TransfersResponse;
import com.perfect.team.impl.rest.service.base.AuthCrudRestService;


/**
 * Created by Denis on 25.11.2017.
 */
public interface TransferRestService
        extends AuthCrudRestService<TransferRequest, TransferResponse, TransfersResponse> {
}
