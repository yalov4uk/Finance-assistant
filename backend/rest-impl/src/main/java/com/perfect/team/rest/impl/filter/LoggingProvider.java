package com.perfect.team.rest.impl.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class LoggingProvider implements ContainerRequestFilter, ContainerResponseFilter {

  private static Logger logger = LoggerFactory.getLogger(LoggingProvider.class);

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ReaderWriter.writeTo(requestContext.getEntityStream(), output);
    byte[] body = output.toByteArray();
    logger.info("Request method: {}, uri: {}, headers: {}, body: {}", requestContext.getMethod(),
        requestContext.getUriInfo().getRequestUri(), requestContext.getHeaders(), new String(body));
    requestContext.setEntityStream(new ByteArrayInputStream(body));
  }

  @Override
  public void filter(ContainerRequestContext requestContext,
      ContainerResponseContext responseContext) throws IOException {
    // todo: shit!!!!!
    logger.info("Response status: {}, body: {}", responseContext.getStatus(),
        responseContext.getEntityStream());
  }
}
