package com.john.autowire;

import com.john.autowire.multi.BeanManager;
import com.john.autowire.multi.BeanOperator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "com.john.autowire.multi")
public class MultiAutowireApp
{
    public static void main( String[] args )
    {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(MultiAutowireApp.class);
		applicationContext.refresh();
		///ListableBeanFactory listableBeanFactory = applicationContext.getBeanFactory();

//		AnnotationConfig config = (AnnotationConfig) listableBeanFactory.getBean(AnnotationConfig.class);
//		System.out.println(config);


		BeanManager bean = applicationContext.getBean(BeanManager.class);

		System.out.println(bean);
	}

	@Bean
	public BeanOperator beanOperator(){
    	return  new BeanOperator();
	}

	@Bean
	public BeanOperator beanOperator1(){
		return  new BeanOperator();
	}
}
