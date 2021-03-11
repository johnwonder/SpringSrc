package com.john.beanFactory;

import com.john.aop.Person;
import com.john.beanFactory.Singer;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class BeanFactoryArgsApp
{
    public static void main( String[] args )
    {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config-args.xml");

		ListableBeanFactory listableBeanFactory = applicationContext.getBeanFactory();

		//覆盖了默认的构造函数 但是必须提供两个参数，不然就找不到可用的constructor
		Singer singer = (Singer) listableBeanFactory.getBean("singer","美国","男");

		System.out.println(singer);

		//配置文件里的构造参数必须去掉或者匹配
		System.out.println(listableBeanFactory.getBean(Singer.class));
	}


}
