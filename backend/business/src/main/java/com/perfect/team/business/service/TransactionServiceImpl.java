package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import com.perfect.team.business.service.base.AuthCrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransactionServiceImpl extends AuthCrudServiceBase<Transaction> implements TransactionService {

    @Inject
    private TransactionMapper transactionMapper;

    @Override
    protected AuthCrudMapper<Transaction> getMapper() {
        return transactionMapper;
    }
}
