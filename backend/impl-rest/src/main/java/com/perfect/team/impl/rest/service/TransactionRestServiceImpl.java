package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.TransactionDto;
import com.perfect.team.api.rest.model.entity.UserDto;
import com.perfect.team.api.rest.request.TransactionRequest;
import com.perfect.team.api.rest.response.TransactionResponse;
import com.perfect.team.api.rest.response.TransactionsResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.service.TransactionService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransactionRestServiceImpl extends CrudRestServiceImpl implements TransactionRestService {
    @Inject
    private TransactionService transactionService;

    @Override
    public TransactionsResponse findByUserId(Long id) {
        List<Transaction> transactions = transactionService.findByUserId(id);
        TransactionsResponse transactionResponse = new TransactionsResponse();
        transactionResponse.setTransactionDtos(transactions
                .stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList()));
        return transactionResponse;
    }

    @Override
    public TransactionResponse findById(Long id) {
        Transaction transaction = transactionService.findById(id);
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionDto(modelMapper.map(transaction, TransactionDto.class));
        return transactionResponse;
    }

    @Override
    public TransactionResponse save(TransactionRequest transactionRequest) {
        Transaction transaction = modelMapper.map(transactionRequest.getTransactionDto(), Transaction.class);
        transaction = transactionService.save(transaction);
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionDto(modelMapper.map(transaction, TransactionDto.class));
        return transactionResponse;
    }

    @Override
    public void delete(TransactionRequest transactionRequest){
        Transaction transaction = modelMapper.map(transactionRequest.getTransactionDto(), Transaction.class);
        transactionService.delete(transaction.getId());
    }
}
