package com.john;

import com.john.beans.jdbcValueBean;
import com.john.properties.jdbcBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
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
public class PlaceHolderUseBeanFactoryTest {

	//https://stackoverflow.com/questions/16460153/xmlbeanfactory-cant-load-properties-file-as-place-holder
	//A bean factory post-processor is a java class which implements the org.springframework.beans.factory.config.BeanFactoryPostProcessor interface.
	// It is executed manually (in the case of the BeanFactory) or automatically (in the case of the ApplicationContext) to apply changes of some sort to an entire BeanFactory,
	// after it has been constructed. Spring includes a number of pre-existing bean factory post-processors,
	// such as PropertyResourceConfigurer and PropertyPlaceHolderConfigurer, both described below, and BeanNameAutoProxyCreator,
	// very useful for wrapping other beans transactionally or with any other kind of proxy, as described later in this manual.
	@Test
	public void testPropertyPostBeanFactory()
	{
		Resource resource = new ClassPathResource("datasource3.xml");
		Resource properties = new ClassPathResource("jdbc.properties");

		Resource properties1 = new ClassPathResource("jdbc1.properties");


		XmlBeanFactory xmlBeanFactory =new XmlBeanFactory(resource);
//		System.out.println(xmlBeanFactory.getBeanDefinitionCount());
//		String[] beanNames = xmlBeanFactory.getBeanDefinitionNames();
//		for (String beanName :beanNames){
//			System.out.println(beanName);
//		}


//		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
//		cfg.setLocation(properties);
//		cfg.setIgnoreUnresolvablePlaceholders(true);
//		cfg.postProcessBeanFactory(xmlBeanFactory);
//
//		PropertyPlaceholderConfigurer cfg1 = new PropertyPlaceholderConfigurer();
//		cfg1.setLocation(properties1);
//		cfg.setIgnoreUnresolvablePlaceholders(true);
//		cfg1.postProcessBeanFactory(xmlBeanFactory);
//

		//加载的是PropertySourcesPlaceholderConfigurer 这个bean 因为xsd里配置的system-properties-mode 属性默认是  ENVIRONMENT
		PropertySourcesPlaceholderConfigurer cfgBean = (PropertySourcesPlaceholderConfigurer)xmlBeanFactory.getBean(PropertySourcesPlaceholderConfigurer.class);
		cfgBean.postProcessBeanFactory(xmlBeanFactory);
		jdbcBean jdbcBean = (com.john.properties.jdbcBean)xmlBeanFactory.getBean("jdbc");
		System.out.println(jdbcBean.getUrl());

		jdbcBean jdbc1Bean = (com.john.properties.jdbcBean)xmlBeanFactory.getBean("johnwonder");
		System.out.println(jdbc1Bean.getUrl());

	}

	//https://vimsky.com/examples/detail/java-method-org.springframework.beans.factory.config.PropertyPlaceholderConfigurer.postProcessBeanFactory.html
	//https://blog.csdn.net/pythias_/article/details/82752881 BeanFactory和ApplicationContext的区别
	// https://www.cnblogs.com/javahr/p/8376742.html <context:property-placeholder> 使用总结


	//https://www.cnblogs.com/fnlingnzb-learner/p/10384742.html PropertyPlaceHolder 加解密

	//https://blog.csdn.net/Cool_Coding/article/details/90617687  Spring加载Properties配置文件的几种方式
}
