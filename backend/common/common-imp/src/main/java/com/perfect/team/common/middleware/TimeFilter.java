package com.perfect.team.common.middleware;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Order(-150)
public class TimeFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    long startTime = System.currentTimeMillis();
    filterChain.doFilter(httpServletRequest, httpServletResponse);
    long elapsedTime = System.currentTimeMillis() - startTime;
    log.info("Executed in {} ms", elapsedTime);
  }
}
