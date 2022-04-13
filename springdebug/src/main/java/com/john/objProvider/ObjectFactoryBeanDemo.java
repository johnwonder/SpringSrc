package com.john.objProvider;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/8
 */
@ComponentScan
public class ObjectFactoryBeanDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext();
		applicationContext.register(ObjectFactoryBeanDemo.class);
	  	applicationContext.refresh();

		ExportFactory exportFactory = applicationContext.getBean(ExportFactory.class);
		System.out.println(exportFactory.getExportFactory().getObject() instanceof ExportImpl);

		System.out.println(exportFactory.getExportFactory().getObject() instanceof ObjectFactory);

	}

	@Bean
	ObjectFactoryCreatingFactoryBean exportFactory(){

		ObjectFactoryCreatingFactoryBean factoryCreatingFactoryBean = new ObjectFactoryCreatingFactoryBean();
		factoryCreatingFactoryBean.setTargetBeanName("exportImpl");
		return  factoryCreatingFactoryBean;
	}
}
