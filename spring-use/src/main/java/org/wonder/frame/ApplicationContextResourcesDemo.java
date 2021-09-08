package org.wonder.frame;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/17
 */
public class ApplicationContextResourcesDemo extends PathMatchingResourcePatternResolver {

	public static void main(String[] args) {

		ApplicationContextResourcesDemo matchingResourcePatternResolver = new ApplicationContextResourcesDemo();
		String rootDir = matchingResourcePatternResolver.determineRootDir("classpath*:/");
		System.out.println(rootDir);
//		ClassPathXmlApplicationContext applicationContext=  new ClassPathXmlApplicationContext();
//
//		applicationContext.setConfigLocation("classpath:spring-bean*.xml");
//		applicationContext.refresh();
//		String[] beanNames = applicationContext.getBeanDefinitionNames();
//
//		for (String beanName : beanNames) {
//
//			System.out.println(beanName);
//		}

	}


}
