package com.perfect.team.rest.impl.filter;

import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @see WebRequestTraceFilter
 */
@Component
public class LoggingFilter extends OncePerRequestFilter {

  private static Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

  private ErrorAttributes errorAttributes;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    long startTime = System.nanoTime();
    Map<String, Object> trace = getTrace(request);
    int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    try {
      filterChain.doFilter(request, response);
      status = response.getStatus();
    } finally {
      addTimeTaken(trace, startTime);
      enhanceTrace(trace, status == response.getStatus() ? response
          : new CustomStatusResponseWrapper(response, status));
      logger.info("{}", trace);
    }
  }


  protected Map<String, Object> getTrace(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");
    Principal userPrincipal = request.getUserPrincipal();
    Map<String, Object> trace = new LinkedHashMap<>();
    Map<String, Object> headers = new LinkedHashMap<>();
    trace.put("method", request.getMethod());
    trace.put("path", request.getRequestURI());
    trace.put("headers", headers);
    headers.put("request", getRequestHeaders(request));
    add(trace, "pathInfo", request.getPathInfo());
    add(trace, "pathTranslated", request.getPathTranslated());
    add(trace, "contextPath", request.getContextPath());
    add(trace, "userPrincipal", (userPrincipal == null ? null : userPrincipal.getName()));
    trace.put("parameters", getParameterMapCopy(request));
    add(trace, "query", request.getQueryString());
    add(trace, "authType", request.getAuthType());
    add(trace, "remoteAddress", request.getRemoteAddr());
    add(trace, "sessionId", (session == null ? null : session.getId()));
    add(trace, "remoteUser", request.getRemoteUser());
    if (exception != null && this.errorAttributes != null) {
      trace.put("error",
          this.errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), true));
    }
    return trace;
  }

  private Map<String, Object> getRequestHeaders(HttpServletRequest request) {
    Map<String, Object> headers = new LinkedHashMap<>();
    Enumeration<String> names = request.getHeaderNames();
    while (names.hasMoreElements()) {
      String name = names.nextElement();
      headers.put(name, getHeaderValue(request, name));
    }
    return headers;
  }

  private Object getHeaderValue(HttpServletRequest request, String name) {
    List<String> value = Collections.list(request.getHeaders(name));
    if (value.size() == 1) {
      return value.get(0);
    }
    if (value.isEmpty()) {
      return "";
    }
    return value;
  }

  private Map<String, String[]> getParameterMapCopy(HttpServletRequest request) {
    return new LinkedHashMap<>(request.getParameterMap());
  }

  private void addTimeTaken(Map<String, Object> trace, long startTime) {
    long timeTaken = System.nanoTime() - startTime;
    add(trace, "timeTaken", "" + TimeUnit.NANOSECONDS.toMillis(timeTaken));
  }

  @SuppressWarnings("unchecked")
  protected void enhanceTrace(Map<String, Object> trace, HttpServletResponse response) {
    Map<String, Object> headers = (Map<String, Object>) trace.get("headers");
    headers.put("response", getResponseHeaders(response));
  }

  private Map<String, String> getResponseHeaders(HttpServletResponse response) {
    Map<String, String> headers = new LinkedHashMap<String, String>();
    for (String header : response.getHeaderNames()) {
      String value = response.getHeader(header);
      headers.put(header, value);
    }
    headers.put("status", "" + response.getStatus());
    return headers;
  }

  private void add(Map<String, Object> trace, String name,
      Object value) {
    if (value != null) {
      trace.put(name, value);
    }
  }

  private static final class CustomStatusResponseWrapper extends HttpServletResponseWrapper {

    private final int status;

    private CustomStatusResponseWrapper(HttpServletResponse response, int status) {
      super(response);
      this.status = status;
    }

    @Override
    public int getStatus() {
      return this.status;
    }
  }
}
