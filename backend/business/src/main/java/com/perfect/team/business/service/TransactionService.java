package com.perfect.team.business.service;

import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.validation.TransactionCreate;
import com.perfect.team.business.validation.TransactionId;
import com.perfect.team.business.validation.TransactionUpdate;
import com.perfect.team.business.validation.UserId;
import java.util.Collection;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TransactionService {

  Long create(@TransactionCreate Transaction bean);

  Transaction read(@TransactionId Long id);

  Transaction update(@TransactionUpdate Transaction bean);

  void delete(@TransactionId Long id);

  Collection<Transaction> readAll();

  Collection<Transaction> readByUserId(@UserId Long userId);
}
