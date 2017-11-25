package com.perfect.team.business.service;

import com.perfect.team.business.entity.Account;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public interface AccountService {
    Account save(Account account);

    List<Account> findByUserId(Long userId);

    Account findById(Long accountId);

    List<Account> findAll();
}
