package com.perfect.team.business.service;

import com.perfect.team.business.dao.TransferDao;
import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.service.base.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransferServiceImpl extends CrudServiceImpl<Transfer> implements TransferService {

    @Inject
    private TransferDao transferDao;

    @Override
    protected CrudDao<Transfer> getDao() {
        return transferDao;
    }

    @Override
    public List<Transfer> readByUserId(Long userId) {
        return transferDao.readByUserId(userId);
    }
}
