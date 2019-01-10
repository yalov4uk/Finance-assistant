package com.perfect.team.auth.imp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfect.team.common.security.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenServiceImp implements TokenService {

  private final JwtService jwtService;
  private final ObjectMapper objectMapper;

  @Override
  public String decrypt(String token) {
    UserContext userContext = jwtService.parse(token);
    try {
      token = objectMapper.writeValueAsString(userContext);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return token;
  }
}
