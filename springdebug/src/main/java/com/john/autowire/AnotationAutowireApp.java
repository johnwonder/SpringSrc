package com.john.autowire;

import com.john.applicationContext.ArticleService;
import com.john.applicationContext.IndexService;
import com.john.beanFactory.Singer;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "com.john.autowire")
public class AnotationAutowireApp
{
    public static void main( String[] args )
    {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(AnotationAutowireApp.class);
		applicationContext.refresh();
		///ListableBeanFactory listableBeanFactory = applicationContext.getBeanFactory();

//		AnnotationConfig config = (AnnotationConfig) listableBeanFactory.getBean(AnnotationConfig.class);
//		System.out.println(config);


		AutowireTest1 bean = applicationContext.getBean(AutowireTest1.class);

		System.out.println(bean.getAutowireTest2());

		System.out.println(bean.getAutowireTest2());
	}


}
