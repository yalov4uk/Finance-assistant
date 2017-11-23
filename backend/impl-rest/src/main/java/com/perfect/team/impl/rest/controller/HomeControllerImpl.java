package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.HomeController;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.repository.mybatis.UserMapper;
import com.perfect.team.business.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class HomeControllerImpl implements HomeController {


    @Inject
    private UserService userService;

    @Inject
    private UserMapper userMapper;

    @RequestMapping("/test")
    public String home() {

        User user = new User("name", "email");
        userMapper.create(user);

        user = userMapper.get(user.getId());

        user.setName("name1");
        userMapper.update(user);

        List<User> users = userMapper.getAll();

        userMapper.delete(user.getId());

        user = userMapper.get(user.getId());

        return "Hello World! There are " + userService.findAll().size() + " registered users.";
    }
}
