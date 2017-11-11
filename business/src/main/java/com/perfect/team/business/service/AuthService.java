package com.perfect.team.business.service;

import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.entity.User;

public interface AuthService {

    User signUp(User user);

    AuthUser signIn(String username, String password);
}
