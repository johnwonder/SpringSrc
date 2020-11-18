package com.john.properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class PropertiesBeanDefinitionDemo {

	public static void main(String[] args) {


		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		//XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader();
		//beanDefinitionReader.loadBeanDefinitions()


		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);

		//1.为什么要用ApplicationContext ，如果这里加了占位符，那么 reader是不会解析占位符的
		//而applicationContext能解析占位符。。
		//2.只有BeanFactory的话 那就要手动去loadBeanDefinition
		//3. beanFactory还要自己 去 实例化单例Bean
		//4. applicationContext默认会初始化所有不是延迟初始化的单例bean
		// XML 配置文件 ClassPath 路径
		String location = "classpath:/propertiesbean.properties";
		// 加载配置
		int beanDefinitionsCount = reader.loadBeanDefinitions(location);



		Employee	employee = beanFactory.getBean(Employee.class);

		System.out.println(employee);
	}
}
