package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.HomeController;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.repository.mybatis.mapper.AccountMapper;
import com.perfect.team.business.repository.mybatis.mapper.CategoryMapper;
import com.perfect.team.business.repository.mybatis.mapper.TransactionMapper;
import com.perfect.team.business.repository.mybatis.mapper.TransferMapper;
import com.perfect.team.business.repository.mybatis.mapper.UserMapper;
import com.perfect.team.business.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class HomeControllerImpl implements HomeController {

    @Inject
    private UserService userService;

    @Inject
    private UserMapper userMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private CategoryMapper categoryMapper;

    @Inject
    private TransactionMapper transactionMapper;

    @Inject
    private TransferMapper transferMapper;

    @RequestMapping("/test")
    public String home() {

        Account account1 = accountMapper.select(1L);
        Account account2 = accountMapper.selectWithUser(1L);
        User user = new User("1", "1");
        user.setId(1L);
        account2.setUser(user);
        int updatedRows = accountMapper.update(account2);

        return "Hello World! There are " + userService.findAll().size() + " registered users.";
    }
}
