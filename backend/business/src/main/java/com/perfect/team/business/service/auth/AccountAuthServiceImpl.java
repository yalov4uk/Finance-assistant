package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.AccountService;
import com.perfect.team.business.service.custom.base.CrudService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AccountAuthServiceImpl extends AuthCrudServiceBase<Account> implements AccountAuthService {

    @Inject
    private AccountService accountService;

    @Override
    protected CrudService<Account> getService() {
        return accountService;
    }

    @Override
    protected Long getUserId(Account bean) {
        if (bean.getUser() == null) bean.setUser(new User());
        return bean.getUser().getId();
    }

    @Override
    protected void setUserId(Account bean, Long userId) {
        if (bean.getUser() == null) bean.setUser(new User());
        bean.getUser().setId(userId);
    }

    @Override
    public List<Account> readAll() {
        return accountService.readAllByUserId(getCurrentUser().getId());
    }
}
