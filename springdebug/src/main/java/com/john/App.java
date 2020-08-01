package com.john;

import com.john.aop.test.Landlord;
import com.john.aop.Person;
import com.john.autowire.AutowireTest1;
import com.john.beanFactory.MyBeanFactory;
import com.john.beanFactory.SimpleTarget;
import com.john.beanFactory.Singer;
import com.john.construct.StandardEnv;
import com.john.factorybean.CarFactoryBean;
import com.john.factorybeanpro.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.PropertyPlaceholderHelper;

import java.io.*;
import java.util.HashSet;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//		StandardEnv standardEnv = new StandardEnv();
//
//
//    	try
//		{
//			replaceProperty();
//		}
//		catch (IOException e){
//
//		}





		String XMLPath = "spring-config.xml";
		//https://www.cnblogs.com/wade-luffy/p/6072460.html
		//https://blog.csdn.net/arjelarxfc/article/details/78223983
		//

		//AbstractBeanDefinitionReader
		//XmlBeanDefinitionReader
		////重点看  PathMatchingResourcePatternResolver .getResources

		//1.8.0_144spring-config.xml 从System.getProperties解析占位符
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");


//		applicationContext
		Landlord landlord = (Landlord) applicationContext.getBean("landlord", Landlord.class);
		landlord.service();
		landlord.setId(5);
		Person albert = (Person) applicationContext.getBean("person", Person.class);
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
//		Car car = (Car) applicationContext.getBean("car5");
//		System.out.println(car.getBrand());
//
//
//		Singer jane = (Singer)applicationContext.getBean("Jane");
//		Singer bibi = (Singer)applicationContext.getBean("Bibi");
//		System.out.println(jane);
//		System.out.println(bibi);


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




		//		ILogin login = (ILogin) applicationContext.getBean("loginService");
//		login.loginCheck("boy", "123");
//
//
//		Bean1 bean1 = (Bean1) applicationContext.getBean("bean3");
//		System.out.println("bean1的id为："+	bean1.getId());
//
//
//		//factorybean
//		//https://www.cnblogs.com/shangxiaofei/p/6236310.html
//		//Car car = (Car) applicationContext.getBean("car");
//		//Car car1 = (Car) applicationContext.getBean("car");
//
//		Car car =  applicationContext.getBean(Car.class);
//		Car car1 =  applicationContext.getBean(Car.class);
//		System.out.println("brand:"+car.getBrand());
//
//		//两个对象一样
//		System.out.println(car);
//		System.out.println(car1);
//
//		CarFactoryBean car2 = (CarFactoryBean) applicationContext.getBean("&car");
//		try
//		{
//			//两个新对象
//			System.out.println(car2.getObject());
//			System.out.println(car2.getObject());
//		}
//		catch (Exception e){
//
//		}
//
//
//		//自定义beanFactory
//		//打印出400
//		Car car3 = (Car) MyBeanFactory.getBean("car");
//		System.out.println(car3.getMaxSpeed());
//
//		AutowireTest1 autowireTest1= applicationContext.getBean(AutowireTest1.class);
//		System.out.println(autowireTest1.getAutowireTest2());

		//System.out.println(System.getProperty("java.class.path"));//系统的classpaht路径
		//System.out.println(System.getProperty("user.dir"));//用户的当前路径

    }


}
