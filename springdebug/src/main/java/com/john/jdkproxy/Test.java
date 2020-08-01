package com.john.jdkproxy;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/9
 */
public class Test {

	//https://www.cnblogs.com/qlqwjy/p/7550609.html

	//spring aop
	public static void main(String[] args) {
		// 目标对象
		IUserDao target =null;//= new UserDao();
		// 【原始的类型 】
		//System.out.println(target.getClass());

		// 给目标对象，创建代理对象
		IUserDao proxy =    new ProxyFactory<IUserDao>(IUserDao.class).getProxyInterface();
		// class $Proxy0   内存中动态生成的代理对象
		System.out.println(proxy.getClass());


		// 执行方法   【代理对象】
		proxy.save();
	}
}
