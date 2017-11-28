package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import com.perfect.team.business.service.base.AuthCrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransferServiceImpl extends AuthCrudServiceBase<Transfer> implements TransferService {

    @Inject
    private TransferMapper transferMapper;

    @Override
    protected AuthCrudMapper<Transfer> getMapper() {
        return transferMapper;
    }
}
