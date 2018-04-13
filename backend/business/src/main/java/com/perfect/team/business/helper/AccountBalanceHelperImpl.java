package com.perfect.team.business.helper;

import com.perfect.team.business.exception.ProcessingException;
import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.service.AccountService;
import com.perfect.team.business.service.CategoryService;
import com.perfect.team.business.service.TransactionService;
import java.lang.reflect.Field;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountBalanceHelperImpl implements AccountBalanceHelper {

  @Inject
  private AccountService accountService;

  @Inject
  private CategoryService categoryService;

  @Inject
  private TransactionService transactionService;

  @Override
  public void updateOnCreate(Transaction transaction) {
    transaction.setAccount(accountService.read(transaction.getAccount().getId()));
//    transaction.setCategory(categoryService.read(transaction.getCategory().getId()));

//    CategoryType categoryType = categoryTypeService
//        .read(transaction.getCategory().getCategoryType().getId());
//    CategoryType.BalanceType balanceType = categoryType.getBalanceType();
//    BigDecimal balance = calculateBalance(transaction, balanceType);
//    transaction.getAccount().setBalance(balance);
//    accountService.update(transaction.getAccount().getId(), transaction.getAccount());
  }

  @Transactional
  @Override
  public void updateOnUpdate(Long id, Transaction transaction) {
    Transaction existedTransaction = transactionService.read(id);
    updateOnDelete(existedTransaction.getId());
    mapTransaction(transaction, existedTransaction);
    updateOnCreate(transaction);
  }

  @Override
  public void updateOnDelete(Long id) {
    Transaction transaction = transactionService.read(id);

    transaction.setAccount(accountService.read(transaction.getAccount().getId()));
//    transaction.setCategory(categoryService.read(transaction.getCategory().getId()));

//    CategoryType categoryType = categoryTypeService
//        .read(transaction.getCategory().getCategoryType().getId());
//    CategoryType.BalanceType balanceType = categoryType.getBalanceType().getReverse();
//    BigDecimal balance = calculateBalance(transaction, balanceType);
//    transaction.getAccount().setBalance(balance);
//    accountService.update(transaction.getAccount().getId(), transaction.getAccount());
  }

//  private BigDecimal calculateBalance(Transaction transaction,
//      CategoryType.BalanceType balanceType) {
//    switch (balanceType) {
//      case INCOME:
//        return transaction.getAccount().getBalance().add(transaction.getValue());
//      case OUTCOME:
//        if (transaction
//            .getAccount()
//            .getBalance()
//            .subtract(transaction.getValue())
//            .compareTo(BigDecimal.ZERO) < 0) {
//          throw new ValidationException("Insufficient funds");
//        }
//        return transaction.getAccount().getBalance().subtract(transaction.getValue());
//      default:
//        throw new ValidationException("Wrong category type");
//    }
//  }

  private void mapTransaction(Transaction newTransaction, Transaction existedTransaction) {
    for (Field field : newTransaction.getClass().getDeclaredFields()) {
      try {
        field.setAccessible(true);
        if (field.get(newTransaction) == null) {
          field.set(newTransaction, field.get(existedTransaction));
        }
      } catch (IllegalAccessException e) {
        throw new ProcessingException("Error while update account balance");
      }
    }
  }
}
