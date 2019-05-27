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
		String XMLPath = "spring-config.xml";
		//https://www.cnblogs.com/wade-luffy/p/6072460.html
		//https://blog.csdn.net/arjelarxfc/article/details/78223983
		//

		//AbstractBeanDefinitionReader
		//XmlBeanDefinitionReader
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		ILogin login = (ILogin) applicationContext.getBean("loginService");
		login.loginCheck("boy", "123");


		Bean1 bean1 = (Bean1) applicationContext.getBean("bean3");
		System.out.println("bean1的id为："+	bean1.getId());
		//重点看  PathMatchingResourcePatternResolver .getResources

		System.out.println(System.getProperty("java.class.path"));//系统的classpaht路径
		System.out.println(System.getProperty("user.dir"));//用户的当前路径

    }
}
