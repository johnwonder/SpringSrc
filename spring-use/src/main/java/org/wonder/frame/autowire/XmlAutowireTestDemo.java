package org.wonder.frame.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wonder.frame.autowire.pd.Person;
import org.wonder.frame.autowire.pd.PersonName;
import org.wonder.frame.xmlConfig.SetterBean;

/**
 * @Description: 测试xml中定义property和 autowire的关系
 * @Author: johnwonder
 * @Date: 2021/3/16
 */
public class XmlAutowireTestDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring/spring-config-autowire-test.xml");
         System.out.println(context.getBean(Person.class));//@1


	}
}
