package org.wonder.frame.customBean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import static java.lang.String.format;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/25
 */
public class BeanCustomNodeDemo {


	public static void main(String[] args) {

	     String NS_XML = format("%s/%s-context.xml", "org/wonder/frame/customBean", CustomXmlApplicationContext.class.getSimpleName());
		CustomXmlApplicationContext beanFactory = new CustomXmlApplicationContext(NS_XML);

		CustomBean bean = (CustomBean) beanFactory.getBean("testBean");
		System.out.println("name is:" +bean.getName() +" and age is:"+ bean.getAge());

		CustomBean customBean = (CustomBean) beanFactory.getBean("customisedTestBean");
		System.out.println("name is:" +customBean.getName() +" and age is:"+ customBean.getAge());


	}
}
