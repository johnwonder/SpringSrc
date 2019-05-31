package com.john;

import com.john.autowire.AutowireTest1;
import com.john.beanFactory.MyBeanFactory;
import com.john.factorybean.CarFactoryBean;
import com.john.factorybeanpro.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

		Car car = (Car) applicationContext.getBean("car5");
		System.out.println(car.getBrand());

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
