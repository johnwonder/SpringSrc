package com.john.beanFactory;

import com.john.aop.Person;
import com.john.applicationContext.ArticleService;
import com.john.applicationContext.IndexService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;

/**
 * Hello world!
 *
 */
public class ObjectProviderBeanFactoryApp
{
    public static void main( String[] args )
    {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-objprovider.xml");

		BeanFactory beanFactory = applicationContext.getBeanFactory();

		//根据类型直接获取
		System.out.println("根据类型获取:" +beanFactory.getBean(IndexService.class));

		//根据名称获取bean
		System.out.println("根据名称获取:" +beanFactory.getBean("article"));

		//竟然输出org.springframework.beans.factory.support.DefaultListableBeanFactory$1@2d38eb89
		System.out.println("获取到的BeanProvider为："+beanFactory.getBeanProvider(ArticleService.class));

		//如果有效就会输出
		System.out.println("BeanProvider有效后输出 ："+beanFactory.getBeanProvider(ArticleService.class).getIfAvailable());

		ObjectProvider<ResolvableType> articleResolvableType = beanFactory.getBeanProvider(ResolvableType.forType(ArticleService.class));
		System.out.println("article的ResolvableType为："+articleResolvableType.getIfAvailable());

		//输出article bean的类型
		System.out.println(beanFactory.getType("article"));

		//输出 是否包含article 这个bean
		System.out.println(beanFactory.containsBean("article"));

		Object articleArgs = beanFactory.getBean("article","sss");
		Object articleNoArgs =beanFactory.getBean("article");
		System.out.println("根据参数获取的bean 跟 没有参数获取的bean 是否相等:"+(articleArgs == articleNoArgs));

		Object articleTypeArgs = beanFactory.getBean(ArticleService.class,"sss");
		System.out.println("根据参数获取的bean 跟 类型参数获取的bean 是否相等:"+(articleArgs == articleTypeArgs));

		//输出article的别名
		String[] articleAliases = beanFactory.getAliases("article");
		System.out.println("article的别名个数:"+articleAliases.length);
		for (String articleAlias : articleAliases) {

			System.out.println("article的别名有:"+articleAlias);
		}

		//如果是ArticleService类型就会输出true
		System.out.println("article 是否匹配 ArticleService类型："+beanFactory.isTypeMatch("article", ArticleService.class));
		System.out.println("article 是否匹配 IndexService类型："+beanFactory.isTypeMatch("article", IndexService.class));


	}


}
