package com.perfect.team.business.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.perfect.team.business.exception.ProcessingException;
import com.perfect.team.business.model.User;
import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource("classpath:business.properties")
@Service
public class JwtServiceImpl implements TokenService {

  @Value("${auth0.secret}")
  private String secret;

  @Value("${auth0.issuer}")
  private String issuer;

  @Override
  public String encode(User user) {
    return encode(user.getId());
  }

  @Override
  public String encode(Long userId) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer(issuer)
          .withSubject(userId.toString())
          .sign(algorithm);
    } catch (UnsupportedEncodingException | JWTCreationException exception) {
      throw new ProcessingException(exception.getMessage());
    }
  }

  @Override
  public Long decode(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(issuer)
          .build();
      DecodedJWT jwt = verifier.verify(token);
      return Long.parseLong(jwt.getSubject());
    } catch (UnsupportedEncodingException | JWTVerificationException exception) {
      throw new ProcessingException(exception.getMessage());
    }
  }
}
