package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDaoImpl;
import com.perfect.team.business.repository.mybatis.mapper.TransferMapper;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class TransferDaoImpl extends CrudDaoImpl<Transfer> implements TransferDao {

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
}
