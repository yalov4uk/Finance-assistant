package com.perfect.team.core.config;

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
        packages("com.perfect.team.api.rest.controller");
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}
