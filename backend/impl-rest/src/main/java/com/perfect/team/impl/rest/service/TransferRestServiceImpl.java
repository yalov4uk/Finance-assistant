package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.TransferReadDto;
import com.perfect.team.api.rest.request.entity.TransferRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;
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
        Transfer transfer = modelMapper.map(transferRequest.getTransferReadDto(), Transfer.class);
        if (transferRequest.getTransferReadDto().getDate() != null) {
            transfer.setDate(new Date(transferRequest.getTransferReadDto().getDate()));
        }
        return transfer;
    }

    @Override
    protected TransferResponse mapEntityToResponse(Transfer transfer) {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setTransferReadDto(modelMapper.map(transfer, TransferReadDto.class));
        if (transfer.getDate() != null) {
            transferResponse.getTransferReadDto().setDate(transfer.getDate().getTime());
        }
        return transferResponse;
    }

    @Override
    protected TransfersResponse mapEntitiesToListResponse(List<Transfer> transfers) {
        TransfersResponse transfersResponse = new TransfersResponse();
        transfersResponse.setTransferReadDtos(transfers
                .stream()
                .map(transfer -> {
                    TransferReadDto transferReadDto = modelMapper.map(transfer, TransferReadDto.class);
                    if (transfer.getDate() != null) {
                        transferReadDto.setDate(transfer.getDate().getTime());
                    }
                    return transferReadDto;
                }).collect(Collectors.toList()));
        return transfersResponse;
    }

    @Override
    protected String getEntityPath() {
        return "transfers/";
    }
}
