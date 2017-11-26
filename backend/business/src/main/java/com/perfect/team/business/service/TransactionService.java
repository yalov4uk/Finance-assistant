package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transaction;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
public interface TransactionService {
    Transaction save(Transaction transaction);

    List<Transaction> findByUserId(Long userId);

    Transaction findById(Long transactionId);

    List<Transaction> findAll();
    void delete(Long id);
}
