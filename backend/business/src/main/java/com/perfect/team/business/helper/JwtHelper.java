package com.perfect.team.business.helper;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtHelper {

  String sign(Long userId, Collection<String> roles);

  UserDetails parse(String token) throws JWTVerificationException, UnsupportedEncodingException;

  DecodedJWT verify(String token) throws UnsupportedEncodingException;
}
