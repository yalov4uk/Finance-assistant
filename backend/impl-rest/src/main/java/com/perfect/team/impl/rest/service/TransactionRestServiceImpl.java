package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.TransactionDto;
import com.perfect.team.api.rest.request.TransactionRequest;
import com.perfect.team.api.rest.response.TransactionResponse;
import com.perfect.team.api.rest.response.TransactionsResponse;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.service.TransactionService;
import com.perfect.team.business.service.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransactionRestServiceImpl
        extends CrudRestServiceImpl<TransactionRequest, Transaction, TransactionResponse, TransactionsResponse>
        implements TransactionRestService {

    @Inject
    private TransactionService transactionService;

    @Override
    public TransactionsResponse readByUserId(Long userId) {
        List<Transaction> transactions = transactionService.readByUserId(userId);
        return mapEntitiesToListResponse(transactions);
    }

    @Override
    protected CrudService<Transaction> getCrudService() {
        return transactionService;
    }

    @Override
    protected Transaction mapRequestToEntity(TransactionRequest transactionRequest) {
        return modelMapper.map(transactionRequest.getTransactionDto(), Transaction.class);
    }

    @Override
    protected TransactionResponse mapEntityToResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionDto(modelMapper.map(transaction, TransactionDto.class));
        return transactionResponse;
    }

    @Override
    protected TransactionsResponse mapEntitiesToListResponse(List<Transaction> transactions) {
        TransactionsResponse transactionsResponse = new TransactionsResponse();
        transactionsResponse.setTransactionDtos(transactions
                .stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList()));
        return transactionsResponse;
    }
}
