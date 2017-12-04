package com.perfect.team.core.config;

import com.perfect.team.api.rest.controller.AccountController;
import com.perfect.team.api.rest.controller.AuthController;
import com.perfect.team.api.rest.controller.CategoryController;
import com.perfect.team.api.rest.controller.TransactionController;
import com.perfect.team.api.rest.controller.TransferController;
import com.perfect.team.api.rest.controller.UserController;
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
        register(AccountController.class);
        register(AuthController.class);
        register(CategoryController.class);
        register(TransactionController.class);
        register(TransferController.class);
        register(UserController.class);

        register(ForbiddenExceptionHandler.class);
        register(NotFoundExceptionHandler.class);
        register(ValidationExceptionHandler.class);
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}
