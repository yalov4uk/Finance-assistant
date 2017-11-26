package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Inject
    private TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public Transaction findById(Long transactionId) {
        return transactionRepository.findOne(transactionId);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(id);
    }

}
