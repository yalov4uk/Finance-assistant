package com.perfect.team.auth.imp.controller;

import com.perfect.team.auth.api.AuthController;
import com.perfect.team.auth.api.dto.CredentialRequest;
import com.perfect.team.auth.api.dto.TokenResponse;
import com.perfect.team.auth.imp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthControllerImp implements AuthController {

  private final AuthService authService;

  @Override
  public ResponseEntity<TokenResponse> signIn(CredentialRequest request) {
    String token = authService
        .signIn(request.getCredentialDto().getUsername(), request.getCredentialDto().getPassword());
    TokenResponse response = new TokenResponse(token);
    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<TokenResponse> signInWithFacebook(String authCode) {
    String token = authService.signInWithFacebook(authCode);
    TokenResponse response = new TokenResponse(token);
    return ResponseEntity.ok(response);
  }
}
