package com.perfect.team.rest.impl.helper;

import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.request.base.BaseRequest;
import javax.ws.rs.core.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class RequestHelper {

  public void prepareRequest(AuthRequest request, HttpHeaders headers) {
    String token = headers.getHeaderString("Auth-token");
    request.setToken(token);
  }

  public void prepareRequest(BaseRequest request, HttpHeaders headers) {
  }
}
