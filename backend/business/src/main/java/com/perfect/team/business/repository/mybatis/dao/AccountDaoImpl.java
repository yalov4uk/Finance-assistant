package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDaoImpl;
import com.perfect.team.business.repository.mybatis.mapper.AccountMapper;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

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
}
