package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Account;

import java.util.List;

public interface AccountDao extends CrudDao<Account> {

    Account readWithUser(Long id);

    List<Account> readByUserId(Long userId);
}
