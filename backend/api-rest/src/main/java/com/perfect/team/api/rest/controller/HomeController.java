package com.perfect.team.api.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/home")
public interface HomeController {

    @GET
    String hello();
}
