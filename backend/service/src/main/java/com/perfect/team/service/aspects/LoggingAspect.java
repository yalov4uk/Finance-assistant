package com.perfect.team.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(10)
@Component
public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(public * com.perfect.team.service.api..*(..))")
    public Object authenticate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        for (Object arg : proceedingJoinPoint.getArgs()) {
            logger.info("Request: {}", arg.toString());
        }
        Object result = proceedingJoinPoint.proceed();
        logger.info("Response: {}", result != null ? result.toString() : null);
        return result;
    }
}
