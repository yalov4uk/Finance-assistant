package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Transaction;

import java.util.List;

public interface TransactionDao extends CrudDao<Transaction> {

    Transaction readWithFull(Long id);

    List<Transaction> readByUserId(Long userId);
}
