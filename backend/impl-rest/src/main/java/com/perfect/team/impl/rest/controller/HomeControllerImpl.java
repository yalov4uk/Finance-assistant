package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.HomeController;
import com.perfect.team.business.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class HomeControllerImpl implements HomeController {


    @Inject
    private UserService userService;

    @RequestMapping("/test")
    public String home() {
        return "Hello World! There are " + userService.findAll().size() + " registered users.";
    }
}
