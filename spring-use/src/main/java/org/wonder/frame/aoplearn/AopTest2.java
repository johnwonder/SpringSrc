package org.wonder.frame.aoplearn;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/18
 */
public class AopTest2 {

	public static void main(String[] args) {

		//代理工厂
		ProxyFactory proxyFactory = new ProxyFactory(new FundsService());
		//添加一个异常通知，发现异常之后发送消息给开发者尽快修复bug
		proxyFactory.addAdvice(new SendMsgThrowsAdvice());
		//通过代理工厂创建代理
		FundsService proxy = (FundsService) proxyFactory.getProxy();
		//调用代理的方法
		proxy.cashOut("路人", 2000);
	}
}
