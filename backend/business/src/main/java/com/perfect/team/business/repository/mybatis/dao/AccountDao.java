package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDao;

public interface AccountDao extends CrudDao<Account> {

    Account readWithUser(Long id);
}
