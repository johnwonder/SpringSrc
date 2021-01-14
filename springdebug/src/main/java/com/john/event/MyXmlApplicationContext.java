package com.john.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/12
 */
public class MyXmlApplicationContext  extends ClassPathXmlApplicationContext {

	public MyXmlApplicationContext(String configLocation) throws BeansException {
		super(configLocation);
	}

	@Override
	protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {

		reader.setEventListener(new MyReaderEventListener());
		super.initBeanDefinitionReader(reader);
	}
}
