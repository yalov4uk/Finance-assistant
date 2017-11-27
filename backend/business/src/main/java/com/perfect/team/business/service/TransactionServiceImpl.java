package com.perfect.team.business.service;

import com.perfect.team.business.dao.TransactionDao;
import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.service.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransactionServiceImpl extends CrudServiceBase<Transaction> implements TransactionService {

    @Inject
    private TransactionDao transactionDao;

    @Override
    protected CrudDao<Transaction> getDao() {
        return transactionDao;
    }

    @Override
    public List<Transaction> readByUserId(Long userId) {
        return transactionDao.readByUserId(userId);
    }
}
