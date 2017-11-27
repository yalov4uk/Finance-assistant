package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDaoBase;
import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TransferDaoImpl extends CrudDaoBase<Transfer> implements TransferDao {

    @Inject
    private TransferMapper transferMapper;

    @Override
    protected CrudMapper<Transfer> getMapper() {
        return transferMapper;
    }

    @Override
    public Transfer readWithFull(Long id) {
        return transferMapper.selectWithFull(id);
    }

    @Override
    public List<Transfer> readByUserId(Long userId) {
        return transferMapper.selectByUserId(userId);
    }
}
