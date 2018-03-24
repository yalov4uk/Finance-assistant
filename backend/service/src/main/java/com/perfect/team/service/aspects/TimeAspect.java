package com.perfect.team.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(20)
@Component
public class TimeAspect {
    private static Logger logger = LoggerFactory.getLogger(TimeAspect.class);

    @Around("execution(public * com.perfect.team.service.api..*(..))")
    public Object authenticate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Method {}.{} executed in {} ms", proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                proceedingJoinPoint.getSignature().getName(), elapsedTime);
        return result;
    }
}
