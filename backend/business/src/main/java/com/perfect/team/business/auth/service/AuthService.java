package com.perfect.team.business.auth.service;

import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.entity.User;

public interface AuthService {

    AuthUser signUp(User user, String confirmPassword);

    AuthUser signIn(String email, String password);

    AuthUser signInWithFacebook(String accessToken);
}
