package com.perfect.team.business.service;

import com.perfect.team.business.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findByUsername(String username);

    User findById(Long userId);

    List<User> findAll();
}
