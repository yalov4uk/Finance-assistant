package com.perfect.team.business.service;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.model.AuthUser;
import com.perfect.team.business.validation.constraint.SignIn;
import com.perfect.team.business.validation.constraint.SignInWith;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService {

  @SignIn
  AuthUser signIn(String email, String password);

  @SignInWith
  AuthUser signInWith(String token, AuthMethod method);
}
