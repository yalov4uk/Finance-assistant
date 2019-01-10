package com.perfect.team.auth.imp.controller;

import com.perfect.team.auth.api.TokenController;
import com.perfect.team.auth.api.dto.TokenRequest;
import com.perfect.team.auth.api.dto.TokenResponse;
import com.perfect.team.auth.imp.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenControllerImp implements TokenController {

  private final TokenService tokenService;

  @Override
  public ResponseEntity<TokenResponse> decrypt(TokenRequest token) {
    String result = tokenService.decrypt(token.getToken());
    return ResponseEntity.ok(new TokenResponse(result));
  }
}
