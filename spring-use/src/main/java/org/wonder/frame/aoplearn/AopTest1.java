package org.wonder.frame.aoplearn;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/18
 */
public class AopTest1 {

	public static void main(String[] args) {

		//代理工厂
		ProxyFactory proxyFactory = new ProxyFactory(new FundsService());
		//添加一个方法前置通知，判断用户名不是“路人”的时候，抛出非法访问异常
		proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> {
			String userName = (String) args1[0];
			//如果不是路人的时候，抛出非法访问异常
			if (!"路人".equals(userName)) {
				throw new RuntimeException(String.format("[%s]非法访问!", userName));
			}
		});
		//通过代理工厂创建代理
		FundsService proxy = (FundsService) proxyFactory.getProxy();
		//调用代理的方法
		proxy.recharge("路人", 100);
		proxy.recharge("张学友", 100);
	}
}
