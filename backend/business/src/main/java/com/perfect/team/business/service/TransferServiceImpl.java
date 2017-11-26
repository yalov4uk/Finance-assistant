package com.perfect.team.business.service;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.repository.TransferRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
@Service
public class TransferServiceImpl implements TransferService {
    @Inject
    private TransferRepository transferRepository;

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> findByUserId(Long userId) {
        return transferRepository.findByUserId(userId);
    }

    @Override
    public Transfer findById(Long transferId) {
        return transferRepository.findOne(transferId);
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        transferRepository.delete(id);
    }

}
