package com.perfect.team.service.impl;

import com.perfect.team.service.api.TransferService;
import com.perfect.team.service.request.TransferCreateRequest;
import com.perfect.team.service.request.TransferUpdateRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.TransferResponse;

import java.net.URI;

public class TransferServiceImpl implements TransferService {
    @Override
    public URI create(TransferCreateRequest request) {
        return null;
    }

    @Override
    public TransferResponse read(Long id) {
        return null;
    }

    @Override
    public TransferResponse update(Long id, TransferUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CategoriesResponse readAll() {
        return null;
    }
}
