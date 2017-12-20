package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.CategoryType;
import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionServiceImpl extends CrudServiceBase<Transaction> implements TransactionService {

    @Inject
    private TransactionMapper transactionMapper;

    @Inject
    private AccountService accountService;

    @Inject
    private CategoryTypeService categoryTypeService;

    @Override
    protected CrudMapper<Transaction> getMapper() {
        return transactionMapper;
    }

    @Override
    protected Long getBeanId(Transaction bean) {
        return bean.getId();
    }

    @Override
    protected void setBeanId(Long id, Transaction bean) {
        bean.setId(id);
    }

    @Override
    public Long create(Transaction bean) {
        if (Objects.equals(bean.getCategory().getCategoryType().getId(), 0L)) {
            bean.getAccount().setBalance(bean.getAccount().getBalance().add(bean.getValue()));
        } else if (Objects.equals(bean.getCategory().getCategoryType().getId(), 1L)) {
            if (bean.getAccount().getBalance().subtract(bean.getValue()).compareTo(BigDecimal.ZERO) < 0) {
        CategoryType categoryType = categoryTypeService.read(bean.getCategory().getCategoryType().getId());
        if (Objects.equals(categoryType.getBalanceType(), CategoryType.BalanceType.INCOME)) {
            bean.getAccount().setBalance(bean.getAccount().getBalance() + bean.getValue());
        } else if (Objects.equals(categoryType.getBalanceType(), CategoryType.BalanceType.OUTCOME)) {
            if (bean.getAccount().getBalance() - bean.getValue() < 0) {
                throw new ValidationException("Insufficient funds");
            }
            bean.getAccount().setBalance(bean.getAccount().getBalance().subtract(bean.getValue()));
        }
        accountService.update(bean.getAccount().getId(), bean.getAccount());
        return super.create(bean);
    }

    @Override
    public Transaction update(Long id, Transaction bean) {
        Transaction existed = read(id);
        if (!Objects.equals(existed.getValue(), bean.getValue())) {
            Account account = accountService.read(existed.getAccount().getId());
            account.setBalance(account.getBalance());
        }
        return super.update(id, bean);
    }

    @Override
    public void delete(Long id) {
        int deletedRows = getMapper().delete(id);
    }

    @Override
    public List<Transaction> readAllByUserId(Long userId) {
        return transactionMapper.selectAllByUserId(userId);
    }
}
