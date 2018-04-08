package com.perfect.team.business.service;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.model.AuthUser;
import com.perfect.team.business.model.User;
import com.perfect.team.business.validation.SignUp;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService {

  User signUp(@SignUp User user);

  AuthUser signIn(String email, String password);

  AuthUser signInWith(String token, AuthMethod method);
}
