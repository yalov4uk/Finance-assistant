package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transfer;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
public interface TransferService {
    Transfer save(Transfer transfer);

    List<Transfer> findByUserId(Long userId);

    Transfer findById(Long transferId);

    List<Transfer> findAll();
    void delete(Long id);
}
