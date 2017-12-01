package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.HomeController;
import org.springframework.stereotype.Component;

@Component
public class HomeControllerImpl implements HomeController {

    @Override
    public String hello() {
        return "Hello Jax-RS";
    }
}
