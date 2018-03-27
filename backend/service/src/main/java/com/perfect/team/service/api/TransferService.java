package com.perfect.team.service.api;

import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.TransferCreateRequest;
import com.perfect.team.service.request.TransferUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.TransferResponse;
import com.perfect.team.service.response.TransfersResponse;
import com.perfect.team.service.validation.TransferCreate;
import com.perfect.team.service.validation.TransferId;
import com.perfect.team.service.validation.TransferUpdate;
import java.net.URI;

public interface TransferService {

  URI create(@TransferCreate TransferCreateRequest request);

  TransferResponse read(@TransferId IdRequest request);

  TransferResponse update(@TransferUpdate TransferUpdateRequest request);

  void delete(@TransferId IdRequest request);

  TransfersResponse readAll(AuthRequest request);
}
