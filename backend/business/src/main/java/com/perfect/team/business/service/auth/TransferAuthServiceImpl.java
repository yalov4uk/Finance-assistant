package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.TransferService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class TransferAuthServiceImpl extends AuthCrudServiceBase<Transfer> implements TransferAuthService {

    @Inject
    private TransferService transferService;

    @Override
    public Long create(Transfer bean) {
        if (Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return transferService.create(bean);
        }
        throw new ForbiddenException("Create transfer to other user not allowed");
    }

    @Override
    public Transfer read(Long id) {
        Transfer transfer = transferService.read(id);
        if (Objects.equals(getCurrentUser().getId(), transfer.getUser().getId())) {
            return transfer;
        }
        throw new ForbiddenException("Read transfer to other user not allowed");
    }

    @Override
    public Transfer update(Long id, Transfer bean) {
        Transfer transfer = transferService.read(id);
        if (Objects.equals(getCurrentUser().getId(), transfer.getUser().getId())
                && Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return transferService.update(id, bean);
        }
        throw new ForbiddenException("Update transfer of other user not allowed");
    }

    @Override
    public void delete(Long id) {
        Transfer transfer = transferService.read(id);
        if (Objects.equals(getCurrentUser().getId(), transfer.getUser().getId())) {
            transferService.delete(id);
        }
        throw new ForbiddenException("Delete transfer of other user not allowed");
    }

    @Override
    public List<Transfer> readAll() {
        return transferService.readAllByUserId(getCurrentUser().getId());
    }
}
