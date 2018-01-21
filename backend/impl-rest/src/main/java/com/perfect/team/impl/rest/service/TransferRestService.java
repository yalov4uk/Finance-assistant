package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;

public interface TransferRestService extends CrudRestService<TransferRequest, TransferResponse, TransfersResponse> {
}
