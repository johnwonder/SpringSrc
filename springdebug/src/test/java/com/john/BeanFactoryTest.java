package com.john;

import com.john.properties.jdbcBean;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static com.john.beanFactory.MyBeanFactory.getBean;
import static org.junit.Assert.assertTrue;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/13
 */
public class BeanFactoryTest {

	@Test
	public void testPropertyPostBeanFactory()
	{
		Resource resource = new ClassPathResource("datasource3.xml");
		Resource properties = new ClassPathResource("jdbc.properties");

		XmlBeanFactory xmlBeanFactory =new XmlBeanFactory(resource);
		System.out.println(xmlBeanFactory.getBeanDefinitionCount());
		String[] beanNames = xmlBeanFactory.getBeanDefinitionNames();
		for (String beanName :beanNames){
			System.out.println(beanName);
		}

//		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
//		cfg.setLocation(properties);
//		cfg.postProcessBeanFactory(xmlBeanFactory);
//
		//加载的是PropertySourcesPlaceholderConfigurer 这个bean
		PropertySourcesPlaceholderConfigurer cfgBean = (PropertySourcesPlaceholderConfigurer)xmlBeanFactory.getBean(PropertySourcesPlaceholderConfigurer.class);
		cfgBean.postProcessBeanFactory(xmlBeanFactory);
		jdbcBean jdbcBean = (com.john.properties.jdbcBean)xmlBeanFactory.getBean("jdbc");

		System.out.println(jdbcBean.getUrl());
	}
}
