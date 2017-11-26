package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.TransferDto;
import com.perfect.team.api.rest.request.TransferRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;


/**
 * Created by Denis on 25.11.2017.
 */
public interface TransferRestService {
    TransfersResponse findByUserId(Long id);
    TransferResponse findById(Long id);
    TransferResponse save(TransferRequest transferRequest);
    void delete(TransferRequest transferRequest);
}
