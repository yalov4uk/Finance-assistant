package com.perfect.team.impl.rest.config;

import com.perfect.team.impl.rest.controller.AccountControllerImpl;
import com.perfect.team.impl.rest.controller.AuthControllerImpl;
import com.perfect.team.impl.rest.controller.CategoryControllerImpl;
import com.perfect.team.impl.rest.controller.TransactionControllerImpl;
import com.perfect.team.impl.rest.controller.TransferControllerImpl;
import com.perfect.team.impl.rest.controller.UserControllerImpl;
import com.perfect.team.impl.rest.provider.exception.ForbiddenExceptionHandler;
import com.perfect.team.impl.rest.provider.exception.NotFoundExceptionHandler;
import com.perfect.team.impl.rest.provider.exception.ValidationExceptionHandler;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api/v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }

    private void registerEndpoints() {
        register(AccountControllerImpl.class);
        register(AuthControllerImpl.class);
        register(CategoryControllerImpl.class);
        register(TransactionControllerImpl.class);
        register(TransferControllerImpl.class);
        register(UserControllerImpl.class);

        register(ForbiddenExceptionHandler.class);
        register(NotFoundExceptionHandler.class);
        register(ValidationExceptionHandler.class);
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}
