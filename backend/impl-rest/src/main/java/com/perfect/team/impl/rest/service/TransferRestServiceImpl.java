package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.TransferDto;
import com.perfect.team.api.rest.request.TransferRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;
import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.service.TransferService;
import com.perfect.team.business.service.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransferRestServiceImpl
        extends CrudRestServiceImpl<TransferRequest, Transfer, TransferResponse, TransfersResponse>
        implements TransferRestService {

    @Inject
    private TransferService transferService;

    @Override
    public TransfersResponse readByUserId(Long userId) {
        List<Transfer> transfers = transferService.readByUserId(userId);
        return mapEntitiesToListResponse(transfers);
    }

    @Override
    protected CrudService<Transfer> getCrudService() {
        return transferService;
    }

    @Override
    protected Transfer mapRequestToEntity(TransferRequest transferRequest) {
        return modelMapper.map(transferRequest.getTransferDto(), Transfer.class);
    }

    @Override
    protected TransferResponse mapEntityToResponse(Transfer transfer) {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setTransferDto(modelMapper.map(transfer, TransferDto.class));
        return transferResponse;
    }

    @Override
    protected TransfersResponse mapEntitiesToListResponse(List<Transfer> transfers) {
        TransfersResponse transfersResponse = new TransfersResponse();
        transfersResponse.setTransferDtos(transfers
                .stream()
                .map(transfer -> modelMapper.map(transfer, TransferDto.class))
                .collect(Collectors.toList()));
        return transfersResponse;
    }
}
