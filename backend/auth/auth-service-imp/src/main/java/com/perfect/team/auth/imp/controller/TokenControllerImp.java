package com.perfect.team.auth.imp.controller;

import com.perfect.team.auth.api.controller.TokenController;
import com.perfect.team.auth.api.dto.TokenResponse;
import com.perfect.team.auth.imp.service.TokenService;
import com.perfect.team.common.security.Role;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenControllerImp implements TokenController {

  private final TokenService tokenService;

  @Override
  @RolesAllowed(Role.INTERNAL)
  public ResponseEntity<TokenResponse> decrypt(String token) {
    String result = tokenService.decrypt(token);
    return ResponseEntity.ok(new TokenResponse(result));
  }
}
