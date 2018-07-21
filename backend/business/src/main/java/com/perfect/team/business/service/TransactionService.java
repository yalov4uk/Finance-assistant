package com.perfect.team.business.service;

import com.perfect.team.common.model.Transaction;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.CategoryId;
import com.perfect.team.business.validation.constraint.TransactionCreate;
import com.perfect.team.business.validation.constraint.TransactionId;
import com.perfect.team.business.validation.constraint.TransactionUpdate;
import com.perfect.team.business.validation.constraint.UserId;
import java.util.Date;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TransactionService {

  Long create(@TransactionCreate Transaction bean);

  List<Transaction> read(@TransactionId Long id, Date date, @CategoryId Long categoryId,
      @AccountId Long accountId, @UserId Long userId);

  Transaction update(@TransactionUpdate Transaction bean);

  void delete(@TransactionId Long id);
}
