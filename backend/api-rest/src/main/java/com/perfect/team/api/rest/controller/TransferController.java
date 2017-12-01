package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.api.rest.response.entity.TransferResponse;
import com.perfect.team.api.rest.response.entity.TransfersResponse;

/**
 * Created by Denis on 26.11.2017.
 */
public interface TransferController extends AuthCrudController<TransferRequest, TransferResponse, TransfersResponse> {
}
