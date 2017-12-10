package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.TransactionDto;
import com.perfect.team.api.rest.request.entity.TransactionRequest;
import com.perfect.team.api.rest.response.entity.TransactionResponse;
import com.perfect.team.api.rest.response.entity.TransactionsResponse;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.service.auth.TransactionAuthService;
import com.perfect.team.business.service.custom.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionRestServiceImpl
        extends CrudRestServiceBase<TransactionRequest, Transaction, TransactionResponse, TransactionsResponse>
        implements TransactionRestService {

    @Inject
    private TransactionAuthService transactionService;

    @Override
    protected CrudService<Transaction> getService() {
        return transactionService;
    }

    @Override
    protected Transaction mapRequestToEntity(TransactionRequest transactionRequest) {
        Transaction transaction = modelMapper.map(transactionRequest.getTransactionDto(), Transaction.class);
        if (transactionRequest.getTransactionDto().getDate() != null) {
            transaction.setDate(new Date(transactionRequest.getTransactionDto().getDate()));
        }
        return transaction;
    }

    @Override
    protected TransactionResponse mapEntityToResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionDto(modelMapper.map(transaction, TransactionDto.class));
        if (transaction.getDate() != null) {
            transactionResponse.getTransactionDto().setDate(transaction.getDate().getTime());
        }
        return transactionResponse;
    }

    @Override
    protected TransactionsResponse mapEntitiesToListResponse(List<Transaction> transactions) {
        TransactionsResponse transactionsResponse = new TransactionsResponse();
        transactionsResponse.setTransactionDtos(transactions
                .stream()
                .map(transaction -> {
                    TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);
                    if (transaction.getDate() != null) {
                        transactionDto.setDate(transaction.getDate().getTime());
                    }
                    return transactionDto;
                })
                .collect(Collectors.toList()));
        return transactionsResponse;
    }

    @Override
    protected String getEntityPath() {
        return "transactions/";
    }
}
