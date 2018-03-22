package com.perfect.team.service.api;

import com.perfect.team.service.request.TransactionCreateRequest;
import com.perfect.team.service.request.TransactionUpdateRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.TransactionResponse;
import com.perfect.team.service.validation.TransactionCreate;
import com.perfect.team.service.validation.TransactionId;
import com.perfect.team.service.validation.TransactionUpdate;

import java.net.URI;

public interface TransactionService {
    URI create(@TransactionCreate TransactionCreateRequest request);

    TransactionResponse read(@TransactionId Long id);

    TransactionResponse update(@TransactionId Long id, @TransactionUpdate TransactionUpdateRequest request);

    void delete(@TransactionId Long id);

    CategoriesResponse readAll();
}
