package com.perfect.team.business.service;

import com.perfect.team.business.entity.User;

public interface UserService {

    User save(User user);

    User findByUsername(String username);
}
