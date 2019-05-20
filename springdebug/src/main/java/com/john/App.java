package com.john;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		String XMLPath = "com/john/spring-config.xml";
		//https://www.cnblogs.com/wade-luffy/p/6072460.html
		//https://blog.csdn.net/arjelarxfc/article/details/78223983
		//

		//AbstractBeanDefinitionReader
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		ILogin login = (ILogin) applicationContext.getBean("loginService");
		login.loginCheck("boy", "123");

		//重点看  PathMatchingResourcePatternResolver .getResources

		System.out.println(System.getProperty("java.class.path"));//系统的classpaht路径
		System.out.println(System.getProperty("user.dir"));//用户的当前路径

    }
}
