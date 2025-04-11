package com.liang.springcore;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("@annotation(com.liang.springcore.Loggable)")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method " + methodName + " is called");
    }

    @Around("@annotation(com.liang.springcore.Monitor)")
    public Object monitorMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(100);
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Method " + joinPoint.getSignature().getName() +
                    " execution time: " + (endTime - startTime) + "ms");
        }
    }
}