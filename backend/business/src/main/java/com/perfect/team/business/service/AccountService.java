package com.perfect.team.business.service;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.base.CrudService;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public interface AccountService extends CrudService<Account> {

    List<Account> readByUserId(Long userId);
}
