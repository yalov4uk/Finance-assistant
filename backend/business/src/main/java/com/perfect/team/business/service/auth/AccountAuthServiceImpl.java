package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.AccountService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class AccountAuthServiceImpl extends AuthCrudServiceBase<Account> implements AccountAuthService {

    @Inject
    private AccountService accountService;

    @Override
    public Long create(Account bean) {
        if (Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return accountService.create(bean);
        }
        throw new ForbiddenException("Create account to other user not allowed");
    }

    @Override
    public Account read(Long id) {
        Account account = accountService.read(id);
        if (Objects.equals(getCurrentUser().getId(), account.getUser().getId())) {
            return account;
        }
        throw new ForbiddenException("Read account to other user not allowed");
    }

    @Override
    public Account update(Long id, Account bean) {
        Account account = accountService.read(id);
        if (Objects.equals(getCurrentUser().getId(), account.getUser().getId())
                && Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return accountService.update(id, bean);
        }
        throw new ForbiddenException("Update account of other user not allowed");
    }

    @Override
    public void delete(Long id) {
        Account account = accountService.read(id);
        if (Objects.equals(getCurrentUser().getId(), account.getUser().getId())) {
            accountService.delete(id);
        }
        throw new ForbiddenException("Delete account of other user not allowed");
    }

    @Override
    public List<Account> readAll() {
        return accountService.readAllByUserId(getCurrentUser().getId());
    }
}
