package com.perfect.team.rest.impl.config;

import com.perfect.team.rest.impl.filter.DtoValidationExceptionHandler;
import com.perfect.team.rest.impl.filter.LoggingProvider;
import com.perfect.team.rest.impl.resource.AccountResourceImpl;
import com.perfect.team.rest.impl.resource.AuthResourceImpl;
import com.perfect.team.rest.impl.resource.CategoryResourceImpl;
import com.perfect.team.rest.impl.resource.ConfirmationResourceImpl;
import com.perfect.team.rest.impl.resource.TransactionResourceImpl;
import com.perfect.team.rest.impl.resource.TransferResourceImpl;
import com.perfect.team.rest.impl.resource.UserResourceImpl;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@ApplicationPath(RestImplConfig.SERVLET_PATH)
@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    registerEndpoints();
    registerHandlers();
    configureSwagger();
  }

  private void registerEndpoints() {
    register(AccountResourceImpl.class);
    register(AuthResourceImpl.class);
    register(CategoryResourceImpl.class);
    register(TransactionResourceImpl.class);
    register(TransferResourceImpl.class);
    register(UserResourceImpl.class);
    register(ConfirmationResourceImpl.class);
  }

  private void registerHandlers() {
    register(DtoValidationExceptionHandler.class);

    register(LoggingProvider.class);
  }

  private void configureSwagger() {
    register(ApiListingResource.class);
    register(SwaggerSerializers.class);
  }
}
