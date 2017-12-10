package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.TransferDto;
import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.api.rest.response.entity.TransferResponse;
import com.perfect.team.api.rest.response.entity.TransfersResponse;
import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.service.auth.TransferAuthService;
import com.perfect.team.business.service.custom.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransferRestServiceImpl
        extends CrudRestServiceBase<TransferRequest, Transfer, TransferResponse, TransfersResponse>
        implements TransferRestService {

    @Inject
    private TransferAuthService transferService;

    @Override
    protected CrudService<Transfer> getService() {
        return transferService;
    }

    @Override
    protected Transfer mapRequestToEntity(TransferRequest transferRequest) {
        Transfer transfer = modelMapper.map(transferRequest.getTransferDto(), Transfer.class);
        if (transferRequest.getTransferDto().getDate() != null) {
            transfer.setDate(new Date(transferRequest.getTransferDto().getDate()));
        }
        return transfer;
    }

    @Override
    protected TransferResponse mapEntityToResponse(Transfer transfer) {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setTransferDto(modelMapper.map(transfer, TransferDto.class));
        if (transfer.getDate() != null) {
            transferResponse.getTransferDto().setDate(transfer.getDate().getTime());
        }
        return transferResponse;
    }

    @Override
    protected TransfersResponse mapEntitiesToListResponse(List<Transfer> transfers) {
        TransfersResponse transfersResponse = new TransfersResponse();
        transfersResponse.setTransferDtos(transfers
                .stream()
                .map(transfer -> {
                    TransferDto transferDto = modelMapper.map(transfer, TransferDto.class);
                    if (transfer.getDate() != null) {
                        transferDto.setDate(transfer.getDate().getTime());
                    }
                    return transferDto;
                }).collect(Collectors.toList()));
        return transfersResponse;
    }

    @Override
    protected String getEntityPath() {
        return "transfers/";
    }
}
