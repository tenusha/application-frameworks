/**
 * 
 */
package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author it16166752
 *
 */
@Aspect
@Component
public class LoggingAspect {

	public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.example.demo.service.*.*(..))")
	public void loggingBefore() {
		logger.info("Before service execution");
	}
	
	@After("execution(* com.example.demo.service.*.*(..))")
	public void loggingAfter() {
		logger.info("After service execution");
	}

}
