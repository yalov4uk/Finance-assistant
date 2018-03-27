package com.perfect.team.service.impl;

import com.perfect.team.service.api.TransferService;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.TransferCreateRequest;
import com.perfect.team.service.request.TransferUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.TransferResponse;
import com.perfect.team.service.response.TransfersResponse;
import java.net.URI;
import org.springframework.stereotype.Service;

@Service("TransferServiceImpl")
public class TransferServiceImpl implements TransferService {

  @Override
  public URI create(TransferCreateRequest request) {
    return null;
  }

  @Override
  public TransferResponse read(IdRequest request) {
    return null;
  }

  @Override
  public TransferResponse update(TransferUpdateRequest request) {
    return null;
  }

  @Override
  public void delete(IdRequest request) {

  }

  @Override
  public TransfersResponse readAll(AuthRequest request) {
    return null;
  }
}
