package com.springcourse.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Around("execution(* com.springcourse.Account.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		Logger logger = Logger.getLogger(className);
		String method = joinPoint.getSignature().toLongString();
		logger.log(Level.INFO, "Before executing: " + method);
		Object result = joinPoint.proceed();
		logger.log(Level.INFO, "After executing: " + method);
		return result;
	}
}
