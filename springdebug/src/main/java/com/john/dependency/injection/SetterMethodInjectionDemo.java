package com.john.dependency.injection;

import com.john.domain.SetterObject;
import com.john.domain.SimpleMovieLister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class SetterMethodInjectionDemo {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-setter-method.xml");
		SetterObject setterObject=(SetterObject)context.getBean("setterObject");
		System.out.print(setterObject);


	}
}
