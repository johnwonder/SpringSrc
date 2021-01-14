package com.john.applicationContext;

import com.john.aop.Person;
import com.john.aop.test.Landlord;
import com.john.beanFactory.SimpleTarget;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class BeanFactoryApp
{
    public static void main( String[] args )
    {






		String XMLPath = "spring-config.xml";
		//https://www.cnblogs.com/wade-luffy/p/6072460.html
		//https://blog.csdn.net/arjelarxfc/article/details/78223983
		//

		//AbstractBeanDefinitionReader
		//XmlBeanDefinitionReader
		////重点看  PathMatchingResourcePatternResolver .getResources

		//1.8.0_144spring-config.xml 从System.getProperties解析占位符
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

		//DefaultListableBeanFactory 实现了BeanDefinitionRegistry 从而有了 registerBeanDefinition 方法
		//DefaultListableBeanFactory 也实现了 ConfigurableListableBeanFactory 接口

		//ConfigurableListableBeanFactory 实现了 ConfigurableBeanFactory
		//applicationContext.getBeanFactory().registerSingleton();
		DefaultListableBeanFactory  beanFactory =(DefaultListableBeanFactory)applicationContext.getBeanFactory();
		Object obj = new Object();
		beanFactory.registerSingleton("test",obj);
		System.out.println(obj == beanFactory.getSingleton("test"));
		//https://www.jianshu.com/p/aff3f01f3641
		//打印出true

		Landlord landlord =  applicationContext.getBean("landlord", Landlord.class);
		landlord.service();
		landlord.setId(5);
		Person albert =  applicationContext.getBean("person", Person.class);
		//Person albert = new Person(1, "Albert", "Camus");
		//Person audrey = new Person(2, "Audrey", "Hepburn");
		//System.out.println(albert);
		//System.out.println(audrey);
		//System.out.println();
		albert.setId(8);
		albert.setLastName("Einstein");
		//audrey.setId(9);
		//audrey.setLastName("Tautou");
		System.out.println();
		System.out.println(albert);
		//System.out.println(audrey);


		//竟然输出14
		System.out.println(applicationContext.getBeanDefinitionCount());

		String[] beanDefinitions = applicationContext.getBeanDefinitionNames();

		for(String bean : beanDefinitions){
			System.out.println(bean);
		}


		//https://blog.csdn.net/sundenskyqq/article/details/44776699
		//https://blog.csdn.net/iteye_14104/article/details/82672514
		ClassPathResource resource = new ClassPathResource("parent.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);


		ClassPathResource childRes = new ClassPathResource("beans.xml");
		DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory(factory);
		XmlBeanDefinitionReader childReader = new XmlBeanDefinitionReader(childFactory);
		childReader.loadBeanDefinitions(childRes);

		SimpleTarget target1 = (SimpleTarget) childFactory.getBean("target1");
		SimpleTarget target2 = (SimpleTarget) childFactory.getBean("target2");
		SimpleTarget target3 = (SimpleTarget) childFactory.getBean("target3");

		System.out.println(target1.getVal());
		System.out.println(target2.getVal());
		System.out.println(target3.getVal());

    }


}
