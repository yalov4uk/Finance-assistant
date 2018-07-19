package com.perfect.team.business.service;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.validation.constraint.SignIn;
import com.perfect.team.business.validation.constraint.SignInWith;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService {

  @SignIn
  String signIn(String email, String password);

  @SignInWith
  String signInWith(String accessToken, AuthMethod method);
}
