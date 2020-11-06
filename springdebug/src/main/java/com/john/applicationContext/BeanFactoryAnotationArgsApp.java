package com.john.applicationContext;

import com.john.beanFactory.Singer;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@ComponentScan
public class BeanFactoryAnotationArgsApp
{
    public static void main( String[] args )
    {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(BeanFactoryAnotationArgsApp.class);
		applicationContext.refresh();
		ListableBeanFactory listableBeanFactory = applicationContext.getBeanFactory();

		Singer singer = (Singer) listableBeanFactory.getBean("singer","美国","男");
		System.out.println(singer);

		//https://www.cnblogs.com/fengxueyi/p/13888562.html
		//https://blog.csdn.net/qq_41907991/article/details/105123387
		//https://www.cnblogs.com/zhangfengxian/p/my-book-list.html
		ObjectProvider<ArticleService> articleServiceObjectProvider = listableBeanFactory.getBeanProvider(ArticleService.class);

		//竟然输出org.springframework.beans.factory.support.DefaultListableBeanFactory$1@c818063
		System.out.println(articleServiceObjectProvider);


		System.out.println(articleServiceObjectProvider.getIfAvailable());

		System.out.println(listableBeanFactory.isTypeMatch("article", ArticleService.class));


		System.out.println(listableBeanFactory.getBean(IndexService.class));

	}


}
