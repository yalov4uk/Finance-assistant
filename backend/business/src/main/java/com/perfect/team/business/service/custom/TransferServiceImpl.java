package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TransferServiceImpl extends CrudServiceBase<Transfer> implements TransferService {

    @Inject
    private TransferMapper transferMapper;

    @Inject
    private AccountService accountService;

    @Override
    protected CrudMapper<Transfer> getMapper() {
        return transferMapper;
    }

    @Override
    protected Long getBeanId(Transfer bean) {
        return bean.getId();
    }

    @Override
    protected void setBeanId(Long id, Transfer bean) {
        bean.setId(id);
    }

    @Override
    public Long create(Transfer bean) {
        if (bean.getFromAccount().getBalance() - bean.getValue() < 0) {
            throw new ValidationException("Insufficient funds");
        }
        bean.getFromAccount().setBalance(bean.getFromAccount().getBalance() - bean.getValue());
        bean.getToAccount().setBalance(bean.getToAccount().getBalance() + bean.getValue());
        accountService.update(bean.getFromAccount().getId(), bean.getFromAccount());
        accountService.update(bean.getToAccount().getId(), bean.getToAccount());
        return super.create(bean);
    }

    @Override
    public List<Transfer> readAllByUserId(Long userId) {
        return transferMapper.selectAllByUserId(userId);
    }
}
