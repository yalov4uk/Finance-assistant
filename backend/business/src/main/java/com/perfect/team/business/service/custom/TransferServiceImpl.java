package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Transfer;
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
    public List<Transfer> readAllByUserId(Long userId) {
        return transferMapper.selectAllByUserId(userId);
    }
}
