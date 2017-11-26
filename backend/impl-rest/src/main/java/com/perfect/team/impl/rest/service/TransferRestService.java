package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.TransferRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;


/**
 * Created by Denis on 25.11.2017.
 */
public interface TransferRestService extends CrudRestService<TransferRequest, TransferResponse, TransfersResponse> {

    TransfersResponse readByUserId(Long userId);
}
