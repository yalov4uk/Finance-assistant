package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDaoImpl;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AccountDaoImpl extends CrudDaoImpl<Account> implements AccountDao {

    @Inject
    private AccountMapper accountMapper;

    @Override
    protected CrudMapper<Account> getMapper() {
        return accountMapper;
    }

    @Override
    public Account readWithUser(Long id) {
        return accountMapper.selectWithUser(id);
    }

    @Override
    public List<Account> readByUserId(Long userId) {
        return accountMapper.selectByUserId(userId);
    }
}
