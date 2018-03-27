package com.perfect.team.business.service.custom;

import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.service.custom.base.CrudService;
import java.util.List;

public interface TransactionService extends CrudService<Transaction> {

  List<Transaction> readAllByUserId(Long userId);
}
