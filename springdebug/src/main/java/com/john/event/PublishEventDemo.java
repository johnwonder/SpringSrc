package com.john.event;

import com.john.xmlconfig.SchoolName;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/14
 */
public class PublishEventDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config-notify.xml");

		context.addApplicationListener(new NotifyListener());

		NotifyEvent event = new NotifyEvent("object", "abc@qq.com", "This is the content");

		context.publishEvent(event);
	}
}
