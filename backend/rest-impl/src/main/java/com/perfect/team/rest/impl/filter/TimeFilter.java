package com.perfect.team.rest.impl.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Order(10)
@Component
public class TimeFilter extends OncePerRequestFilter {

  private static Logger logger = LoggerFactory.getLogger(TimeFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    long startTime = System.currentTimeMillis();
    filterChain.doFilter(httpServletRequest, httpServletResponse);
    long elapsedTime = System.currentTimeMillis() - startTime;
    logger.info("Executed in {} ms", elapsedTime);
  }
}
