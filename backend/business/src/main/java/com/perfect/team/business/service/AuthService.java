package com.perfect.team.business.service;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.model.AuthUser;
import com.perfect.team.business.model.User;
import com.perfect.team.business.validation.constraint.SignIn;
import com.perfect.team.business.validation.constraint.SignInWith;
import com.perfect.team.business.validation.constraint.SignUp;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService {

  User signUp(@SignUp User user);

  @SignIn
  AuthUser signIn(String email, String password);

  @SignInWith
  AuthUser signInWith(String token, AuthMethod method);
}
