package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AccountServiceImpl extends CrudServiceBase<Account> implements AccountService {

    @Inject
    private AccountMapper accountMapper;

    @Override
    protected CrudMapper<Account> getMapper() {
        return accountMapper;
    }

    @Override
    protected Long getBeanId(Account bean) {
        return bean.getId();
    }

    @Override
    protected void setBeanId(Long id, Account bean) {
        bean.setId(id);
    }

    @Override
    public List<Account> readAllByUserId(Long userId) {
        return accountMapper.selectAllByUserId(userId);
    }
}
