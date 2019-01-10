package com.perfect.team.auth.imp.service;

import com.perfect.team.auth.imp.validation.constraint.SignIn;
import com.perfect.team.auth.imp.validation.constraint.SignInWith;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService {

  @SignIn
  String signIn(String username, String password);

  @SignInWith
  String signInWithFacebook(String authCode);
}
