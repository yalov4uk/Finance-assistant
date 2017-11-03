package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.HomeController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerImpl implements HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello Word";
    }
}
