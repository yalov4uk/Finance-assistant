package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.service.custom.base.CrudService;

import java.util.List;

public interface TransferService extends CrudService<Transfer> {

    List<Transfer> readAllByUserId(Long userId);
}
