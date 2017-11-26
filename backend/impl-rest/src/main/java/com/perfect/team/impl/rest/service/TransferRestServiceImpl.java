package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.TransferDto;
import com.perfect.team.api.rest.model.entity.UserDto;
import com.perfect.team.api.rest.request.TransferRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.service.TransferService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class TransferRestServiceImpl extends CrudRestServiceImpl implements TransferRestService {
    @Inject
    private TransferService transferService;

    @Override
    public TransfersResponse findByUserId(Long id) {
        List<Transfer> transfers = transferService.findByUserId(id);
        TransfersResponse transferResponse = new TransfersResponse();
        transferResponse.setTransferDtos(transfers
                .stream()
                .map(transfer -> modelMapper.map(transfer, TransferDto.class))
                .collect(Collectors.toList()));
        return transferResponse;
    }

    @Override
    public TransferResponse findById(Long id) {
        Transfer transfer = transferService.findById(id);
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setTransferDto(modelMapper.map(transfer, TransferDto.class));
        return transferResponse;
    }

    @Override
    public TransferResponse save(TransferRequest transferRequest) {
        Transfer transfer = modelMapper.map(transferRequest.getTransferDto(), Transfer.class);
        transfer = transferService.save(transfer);
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setTransferDto(modelMapper.map(transfer, TransferDto.class));
        return transferResponse;
    }

    @Override
    public void delete(TransferRequest transferRequest){
        Transfer transfer = modelMapper.map(transferRequest.getTransferDto(), Transfer.class);
        transferService.delete(transfer.getId());
    }
}
