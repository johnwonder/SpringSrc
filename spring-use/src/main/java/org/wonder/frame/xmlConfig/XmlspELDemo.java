package org.wonder.frame.xmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/16
 */
public class XmlspELDemo {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring/spring-config-el.xml");
        ElBean elBean =context.getBean("setterBean",ElBean.class);//@2
  		System.out.println(elBean);
	}
}
