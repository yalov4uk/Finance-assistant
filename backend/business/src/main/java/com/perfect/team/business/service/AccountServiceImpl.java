package com.perfect.team.business.service;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Inject
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Account findById(Long accountId) {
        return accountRepository.findOne(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
