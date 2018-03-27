package com.perfect.team.service.impl;

import com.perfect.team.service.api.TransactionService;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.TransactionCreateRequest;
import com.perfect.team.service.request.TransactionUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.TransactionResponse;
import com.perfect.team.service.response.TransactionsResponse;
import java.net.URI;
import org.springframework.stereotype.Service;

@Service("TransactionServiceImpl")
public class TransactionServiceImpl implements TransactionService {

  @Override
  public URI create(TransactionCreateRequest request) {
    return null;
  }

  @Override
  public TransactionResponse read(IdRequest request) {
    return null;
  }

  @Override
  public TransactionResponse update(TransactionUpdateRequest request) {
    return null;
  }

  @Override
  public void delete(IdRequest request) {

  }

  @Override
  public TransactionsResponse readAll(AuthRequest request) {
    return null;
  }
}