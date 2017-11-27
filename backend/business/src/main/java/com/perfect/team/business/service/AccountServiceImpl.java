package com.perfect.team.business.service;

import com.perfect.team.business.dao.AccountDao;
import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class AccountServiceImpl extends CrudServiceBase<Account> implements AccountService {

    @Inject
    private AccountDao accountDao;

    @Override
    protected CrudDao<Account> getDao() {
        return accountDao;
    }

    @Override
    public List<Account> readByUserId(Long userId) {
        return accountDao.readByUserId(userId);
    }
}
