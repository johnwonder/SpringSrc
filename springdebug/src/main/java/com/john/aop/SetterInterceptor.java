package com.john.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.SoftException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: zhangjiong
 * @Date: 2020/4/14
 */
@Aspect
@Component
public class SetterInterceptor {
	@Before("execution(* com.john.aop.*.set*(*)) && target(instance) && args(newValue)")
	public void beforeSetterCalled(JoinPoint thisJoinPoint, Object instance, Object newValue) {
		String methodName = thisJoinPoint.getSignature().getName();
		try {
			System.out.println(
					methodName.substring(3) + ": " +
							instance
									.getClass()
									.getMethod(methodName.replaceFirst("set", "get"))
									.invoke(instance) +
							" -> " + newValue
			);
		} catch (Exception e) {
			throw new SoftException(e);
		}
	}
}