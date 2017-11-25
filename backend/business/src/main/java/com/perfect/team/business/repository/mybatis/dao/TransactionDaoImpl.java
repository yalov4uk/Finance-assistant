package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDaoImpl;
import com.perfect.team.business.repository.mybatis.mapper.TransactionMapper;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

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
}
