package com.perfect.team.business.service.helper;

import com.perfect.team.business.entity.CategoryType;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.service.custom.AccountService;
import com.perfect.team.business.service.custom.CategoryTypeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TransactionBalanceTypeHelperImpl implements TransactionBalanceTypeHelper {

    @Inject
    private AccountService accountService;

    @Inject
    private CategoryTypeService categoryTypeService;

    @Override
    public void updateBalance(Transaction transaction) {
        CategoryType categoryType = categoryTypeService.read(transaction.getCategory().getCategoryType().getId());
        Long balance = calculateBalance(categoryType, transaction);
        transaction.getAccount().setBalance(balance);
        accountService.update(transaction.getAccount().getId(), transaction.getAccount());
    }

    private Long calculateBalance(CategoryType categoryType, Transaction transaction) {
        switch (categoryType.getBalanceType()) {
            case INCOME:
                return transaction.getAccount().getBalance() + transaction.getValue();
            case OUTCOME:
                if (transaction.getAccount().getBalance() - transaction.getValue() < 0) {
                    throw new ValidationException("Insufficient funds");
                }
                return transaction.getAccount().getBalance() - transaction.getValue();
            default:
                throw new ValidationException("Wrong category type");
        }
    }
}
