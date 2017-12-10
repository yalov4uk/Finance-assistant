package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.AccountService;
import com.perfect.team.business.service.custom.TransferService;
import com.perfect.team.business.service.custom.base.CrudService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TransferAuthServiceImpl extends AuthCrudServiceBase<Transfer> implements TransferAuthService {

    @Inject
    private TransferService transferService;

    @Inject
    private AccountAuthService accountAuthService;

    @Inject
    private AccountService accountService;

    @Override
    protected CrudService<Transfer> getService() {
        return transferService;
    }

    @Override
    protected Long getUserId(Transfer bean) {
        if (bean.getUser() == null) bean.setUser(new User());
        return bean.getUser().getId();
    }

    @Override
    protected void setUserId(Transfer bean, Long userId) {
        if (bean.getUser() == null) bean.setUser(new User());
        bean.getUser().setId(userId);
    }

    @Override
    public Long create(Transfer bean) {
        if (bean.getFromAccount() == null) throw new ValidationException("From account is null");
        if (bean.getToAccount() == null) throw new ValidationException("To account is null");
        bean.setFromAccount(accountAuthService.read(bean.getFromAccount().getId()));
        bean.setToAccount(accountService.read(bean.getToAccount().getId()));
        return super.create(bean);
    }

    @Override
    public List<Transfer> readAll() {
        return transferService.readAllByUserId(getCurrentUser().getId());
    }
}
