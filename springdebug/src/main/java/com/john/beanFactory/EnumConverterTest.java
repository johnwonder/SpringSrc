package com.john.beanFactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author johnwonder
 * @version 1.0
 * @date 2020/10/15 8:29
 */
public class EnumConverterTest {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		// XML 配置文件 ClassPath 路径
		String location = "classpath:/enumbean.xml";
		// 加载配置
		int beanDefinitionsCount = reader.loadBeanDefinitions(location);

	    User	user = beanFactory.getBean(User.class);

		System.out.println(user);
	}
}
