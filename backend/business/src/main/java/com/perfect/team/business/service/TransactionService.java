package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.service.base.CrudService;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public interface TransactionService extends CrudService<Transaction> {

    List<Transaction> readByUserId(Long userId);
}
