package com.john.propertyEditor;

import com.john.xmlconfig.SchoolName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/12
 */
public class DefaultPropertyEditorDemo {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config-defaulteditor.xml");



		UUIDBean uuidBean=(UUIDBean)context.getBean("uuidBean");


		System.out.println("uuid value is:"+uuidBean.getUuidName());



//		UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
//		// checking UUID value
//		System.out.println("UUID value is: "+uid);
	}
}
