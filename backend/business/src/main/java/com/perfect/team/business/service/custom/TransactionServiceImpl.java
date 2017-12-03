package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TransactionServiceImpl extends CrudServiceBase<Transaction> implements TransactionService {

    @Inject
    private TransactionMapper transactionMapper;

    @Override
    protected CrudMapper<Transaction> getMapper() {
        return transactionMapper;
    }

    @Override
    protected Long getBeanId(Transaction bean) {
        return bean.getId();
    }

    @Override
    protected void setBeanId(Long id, Transaction bean) {
        bean.setId(id);
    }

    @Override
    public List<Transaction> readAllByUserId(Long userId) {
        return transactionMapper.selectAllByUserId(userId);
    }
}
