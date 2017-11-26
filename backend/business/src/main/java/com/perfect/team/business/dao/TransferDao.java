package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDao;

public interface TransferDao extends CrudDao<Transfer> {

    Transfer readWithFull(Long id);
}
