package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionServiceImpl extends CrudServiceBase<Transaction> implements TransactionService {

    @Inject
    private TransactionMapper transactionMapper;

    @Inject
    private AccountService accountService;

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
    public Long create(Transaction bean) {
        if (Objects.equals(bean.getCategory().getCategoryType().getId(), 0L)) {
            bean.getAccount().setBalance(bean.getAccount().getBalance() + bean.getValue());
        } else if (Objects.equals(bean.getCategory().getCategoryType().getId(), 1L)) {
            if (bean.getAccount().getBalance() - bean.getValue() < 0) {
                throw new ValidationException("Insufficient funds");
            }
            bean.getAccount().setBalance(bean.getAccount().getBalance() - bean.getValue());
        }
        accountService.update(bean.getAccount().getId(), bean.getAccount());
        return super.create(bean);
    }

    @Override
    public List<Transaction> readAllByUserId(Long userId) {
        return transactionMapper.selectAllByUserId(userId);
    }
}
