package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Transfer;

import java.util.List;

public interface TransferDao extends CrudDao<Transfer> {

    Transfer readWithFull(Long id);

    List<Transfer> readByUserId(Long userId);
}
