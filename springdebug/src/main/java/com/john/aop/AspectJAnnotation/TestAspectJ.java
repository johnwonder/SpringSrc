package com.john.aop.AspectJAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/26
 */
@Aspect
@Component
public class TestAspectJ {

	// 定义切点（切入位置）
	@Pointcut("execution(* com.john.aop.AspectJAnnotation.TestBean.*(..))")
	private void pointcut(){}


	@Before("pointcut()")
	public void before(JoinPoint joinPoint){
		System.out.println("我是前置通知");
	}

}
