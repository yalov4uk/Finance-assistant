package com.perfect.team.edge.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.perfect.team.auth.api.dto.TokenRequest;
import com.perfect.team.auth.api.dto.TokenResponse;
import com.perfect.team.auth.client.TokenClient;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthFilter extends ZuulFilter {

  private final TokenClient tokenClient;

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletRequest request = context.getRequest();
    String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (authorization != null) {
      String[] arr = authorization.split(" ");
      if (arr.length > 1) {
        TokenResponse token = tokenClient.decrypt(new TokenRequest(arr[1])).getBody();
        if (token != null) {
          log.debug("Decrypted token = {}", token.getToken());
          context.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, arr[0] + " " + token.getToken());
        }
      }
    }
    return null;
  }
}
