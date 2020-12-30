package com.john.xmlconfig;

import com.john.factorybean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class FactoryBeanAliasNameDemo {

	public static void main( String[] args ) {


		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext();
		ac.setConfigLocations("spring-config-locatorfactory.xml");
		ac.refresh();

		 ac.getBeanFactory().destroySingletons();
		//getBean的时候才会去getObject
		System.out.println(ac.getBean("car", Car.class));

		//System.out.println(ac.getBean("car", Car.class));

//		String[] aliases =  ac.getAliases("&car");
//
//		for (String alias : aliases) {
//
//			System.out.println(alias);
//		}
	}

}
