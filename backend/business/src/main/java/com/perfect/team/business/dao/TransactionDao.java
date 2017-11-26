package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDao;

public interface TransactionDao extends CrudDao<Transaction> {

    Transaction readWithFull(Long id);
}
