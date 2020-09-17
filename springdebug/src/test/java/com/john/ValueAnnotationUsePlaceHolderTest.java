package com.john;

import com.john.beans.jdbcValueBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/13
 */
public class ValueAnnotationUsePlaceHolderTest {

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


		//todo 多个properties文件解析 2020-09-15
		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
		cfg.setLocations(properties,properties1);
		//cfg.setIgnoreUnresolvablePlaceholders(true);
		cfg.postProcessBeanFactory(xmlBeanFactory);

		//value注解解析
		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor =new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(xmlBeanFactory);
		xmlBeanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

		//todo important 不加这行就不能解析
		xmlBeanFactory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());

		jdbcValueBean jdbcValueBean = (com.john.beans.jdbcValueBean)xmlBeanFactory.getBean("jdbcValueBean");

		System.out.println(jdbcValueBean.getUrl());
	}
	//https://blog.csdn.net/pythias_/article/details/82752881 BeanFactory和ApplicationContext的区别
	// https://www.cnblogs.com/javahr/p/8376742.html <context:property-placeholder> 使用总结


	//https://www.cnblogs.com/fnlingnzb-learner/p/10384742.html PropertyPlaceHolder 加解密

	//https://blog.csdn.net/Cool_Coding/article/details/90617687  Spring加载Properties配置文件的几种方式
}
