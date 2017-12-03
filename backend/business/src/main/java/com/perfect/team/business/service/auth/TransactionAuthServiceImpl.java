package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.TransactionService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionAuthServiceImpl extends AuthCrudServiceBase<Transaction> implements TransactionAuthService {

    @Inject
    private TransactionService transactionService;

    @Override
    public Long create(Transaction bean) {
        if (Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return transactionService.create(bean);
        }
        throw new ForbiddenException("Create transaction to other user not allowed");
    }

    @Override
    public Transaction read(Long id) {
        Transaction transaction = transactionService.read(id);
        if (Objects.equals(getCurrentUser().getId(), transaction.getUser().getId())) {
            return transaction;
        }
        throw new ForbiddenException("Read transaction to other user not allowed");
    }

    @Override
    public Transaction update(Long id, Transaction bean) {
        Transaction transaction = transactionService.read(id);
        if (Objects.equals(getCurrentUser().getId(), transaction.getUser().getId())
                && Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return transactionService.update(id, bean);
        }
        throw new ForbiddenException("Update transaction of other user not allowed");
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = transactionService.read(id);
        if (Objects.equals(getCurrentUser().getId(), transaction.getUser().getId())) {
            transactionService.delete(id);
        }
        throw new ForbiddenException("Delete transaction of other user not allowed");
    }

    @Override
    public List<Transaction> readAll() {
        return transactionService.readAllByUserId(getCurrentUser().getId());
    }
}
