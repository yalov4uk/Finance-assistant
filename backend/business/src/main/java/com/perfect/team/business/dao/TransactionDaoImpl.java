package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDaoImpl;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TransactionDaoImpl extends CrudDaoImpl<Transaction> implements TransactionDao {

    @Inject
    private TransactionMapper transactionMapper;

    @Override
    protected CrudMapper<Transaction> getMapper() {
        return transactionMapper;
    }

    @Override
    public Transaction readWithFull(Long id) {
        return transactionMapper.selectWithFull(id);
    }

    @Override
    public List<Transaction> readByUserId(Long userId) {
        return transactionMapper.selectByUserId(userId);
    }
}
