package com.perfect.team.rest.impl.filter;

import com.perfect.team.rest.impl.utils.CachedHttpServletRequestWrapper;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Order(0)
@Component
public class ContentCachingRequestFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    ServletRequest requestWrapper = new CachedHttpServletRequestWrapper(
        (HttpServletRequest) request);
    chain.doFilter(requestWrapper, response);
  }
}
