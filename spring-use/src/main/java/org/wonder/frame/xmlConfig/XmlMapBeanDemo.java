package org.wonder.frame.xmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/16
 */
public class XmlMapBeanDemo {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config-map-ref.xml");
		ElBean elBean = context.getBean("refMapBean", ElBean.class);//@2

		System.out.println(elBean);
		RefBean refBean = context.getBean("refBean", RefBean.class);//@2

		System.out.println(refBean);
	}
}
