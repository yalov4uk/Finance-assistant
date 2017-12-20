package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.TransactionService;
import com.perfect.team.business.service.custom.base.CrudService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TransactionAuthServiceImpl extends AuthCrudServiceBase<Transaction> implements TransactionAuthService {

    @Inject
    private TransactionService transactionService;

    @Inject
    private AccountAuthService accountAuthService;

    @Inject
    private CategoryAuthService categoryAuthService;

    @Override
    protected CrudService<Transaction> getService() {
        return transactionService;
    }

    @Override
    protected Long getUserId(Transaction bean) {
        if (bean.getUser() == null) bean.setUser(new User());
        return bean.getUser().getId();
    }

    @Override
    protected void setUserId(Transaction bean, Long userId) {
        if (bean.getUser() == null) bean.setUser(new User());
        bean.getUser().setId(userId);
    }

    @Override
    public Long create(Transaction bean) {
        if (bean.getAccount() == null) throw new ValidationException("Account is null");
        if (bean.getCategory() == null) throw new ValidationException("Category is null");
        accountAuthService.read(bean.getAccount().getId());
        categoryAuthService.read(bean.getCategory().getId());
        return super.create(bean);
    }

    @Override
    public Transaction update(Long id, Transaction bean) {
        if (bean.getAccount() != null) accountAuthService.read(id);
        if (bean.getCategory() != null) categoryAuthService.read(id);
        return super.update(id, bean);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public List<Transaction> readAll() {
        return transactionService.readAllByUserId(getCurrentUser().getId());
    }
}
