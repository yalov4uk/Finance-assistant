package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.TransferRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Denis on 26.11.2017.
 */
public interface TransferController {
    HttpEntity getAllTransfers();
    HttpEntity getById(@PathVariable("id") Long id);
    HttpEntity update(@RequestBody TransferRequest transferRequest);
    HttpEntity add(@RequestBody TransferRequest transferRequest);
    HttpEntity delete(@RequestBody TransferRequest transferRequest);
}