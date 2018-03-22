package com.perfect.team.service.api;

import com.perfect.team.service.request.TransferCreateRequest;
import com.perfect.team.service.request.TransferUpdateRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.TransferResponse;
import com.perfect.team.service.validation.TransferCreate;
import com.perfect.team.service.validation.TransferId;
import com.perfect.team.service.validation.TransferUpdate;

import java.net.URI;

public interface TransferService {
    URI create(@TransferCreate TransferCreateRequest request);

    TransferResponse read(@TransferId Long id);

    TransferResponse update(@TransferId Long id, @TransferUpdate TransferUpdateRequest request);

    void delete(@TransferId Long id);

    CategoriesResponse readAll();
}
