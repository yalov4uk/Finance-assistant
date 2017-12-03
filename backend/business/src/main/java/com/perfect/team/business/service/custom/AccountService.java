package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.custom.base.CrudService;

import java.util.List;

public interface AccountService extends CrudService<Account> {

    List<Account> readAllByUserId(Long userId);
}
