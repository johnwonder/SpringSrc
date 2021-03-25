package org.wonder.frame.xmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/16
 */
public class XmlAutowireDemo {

	public static void main(String[] args) {

		String str = "serviceB*";
		String strPattern = "service";

		System.out.println(str.indexOf(strPattern));

		//输出*
		System.out.println(str.substring(str.indexOf("*")));

		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring/spring-config-autowire.xml");
         System.out.println(context.getBean(SetterBean.class));//@1

        SetterBean.IService service =context.getBean(SetterBean.IService.class);//@2
  		System.out.println(service);

	}
}
