package com.perfect.team.service.aspects;

import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.security.TokenAuthentication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Aspect
@Order(1)
@Component
public class AuthenticationAspect {
    @Inject
    private AuthenticationManager authenticationManager;

    @Before("execution(public * com.perfect.team.service.api..*(..))")
    public void authenticate(JoinPoint joinPoint) throws AuthenticationException {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof AuthRequest) {
                AuthRequest request = (AuthRequest) arg;
                Authentication authentication = new TokenAuthentication(request.getToken());
                authentication = authenticationManager.authenticate(authentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
    }
}
