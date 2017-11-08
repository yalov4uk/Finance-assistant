package com.perfect.team.business.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.ProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("oauth0.secret")
    private String secret;

    @Value("oauth0.issuer")
    private String issuer;

    @Override
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException exception) {
            throw new ProcessingException(exception.getMessage());
        } catch (JWTCreationException exception) {
            throw new ProcessingException(exception.getMessage());
        }
    }

    @Override
    public String decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject();
        } catch (UnsupportedEncodingException exception) {
            throw new ProcessingException(exception.getMessage());
        } catch (JWTVerificationException exception) {
            throw new ProcessingException(exception.getMessage());
        }
    }
}
