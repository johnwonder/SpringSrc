package org.wonder.frame.aoplearn;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/18
 */
public  class SendMsgThrowsAdvice implements ThrowsAdvice {
	//注意方法名称必须为afterThrowing
	public void afterThrowing(Method method, Object[] args, Object target, RuntimeException e) {
		//监控到异常后发送消息通知开发者
		System.out.println("异常警报：");
		System.out.println(String.format("method:[%s]，args:[%s]", method.toGenericString(), Arrays.stream(args).collect(Collectors.toList())));
		System.out.println(e.getMessage());
		System.out.println("请尽快修复bug！");
	}
}

