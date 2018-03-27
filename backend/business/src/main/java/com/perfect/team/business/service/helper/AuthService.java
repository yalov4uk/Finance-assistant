package com.perfect.team.business.service.helper;

import com.perfect.team.business.model.AuthUser;
import com.perfect.team.business.model.User;


public interface AuthService {

  AuthUser signUp(User user, String confirmPassword);

  AuthUser signIn(String email, String password);

  AuthUser signInWithFacebook(String accessToken);
}
