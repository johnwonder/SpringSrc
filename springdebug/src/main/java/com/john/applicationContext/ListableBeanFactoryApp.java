package com.john.applicationContext;

import com.john.aop.Person;
import com.john.aop.test.Landlord;
import com.john.beanFactory.SimpleTarget;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class ListableBeanFactoryApp
{
    public static void main( String[] args )
    {

		ConfigurableApplicationContext parentContext = new ClassPathXmlApplicationContext("spring-parent.xml");

		ListableBeanFactory parentBeanFactory = parentContext.getBeanFactory();


		//循环输出BeanDefinition的 名字，只获取当前BeanFactory，不考虑父子关系。
		//DefaultListableBeanFactory
		String[] parentBeanDefinitionNames = parentBeanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : parentBeanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		//输出false 代表没有这个beanDefinition
		System.out.println(parentBeanFactory.containsBeanDefinition("person"));

		//输出false 代表没有这个bean
		System.out.println(parentBeanFactory.containsBean("person"));

		//根据别名获取Bean类型
		System.out.println(parentBeanFactory.getType("johnperson"));

		//获取bean别名集合
		String[] personAlias = parentBeanFactory.getAliases("person");
		//输出0
		System.out.println("alias length:"+personAlias.length);

		//the corresponding original bean name and other aliases (if any) will be returned,
		// with the original bean name being the first element in the array.
		String[] johnpeople = parentBeanFactory.getAliases("johnperson");
		for (String johnperson : johnpeople) {

			System.out.println("alias:"+johnperson);
		}


		//判断person是否是singleton 输出true
		System.out.println(parentBeanFactory.isSingleton("person"));

		//判断person是否是prototype 输出false
		System.out.println(parentBeanFactory.isPrototype("person"));

		//输出Person类的 bean集合
		System.out.println(parentBeanFactory.getBeansOfType(Person.class));

		//输出容器中BeanDefinition 的总数 只有当前beanFactory中的bean 为 person
		System.out.println(parentBeanFactory.getBeanDefinitionCount());


		System.out.println("==================================>>>>");

		ConfigurableApplicationContext childContext = new ClassPathXmlApplicationContext("spring-child.xml");

		ListableBeanFactory childBeanFactory = childContext.getBeanFactory();

		//循环输出BeanDefinition的 名字
		String[] beanDefinitionNames = childBeanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		//输出false 代表没有这个beanDefinition，也代表ListableBeanFactory不会输出Parent的Bean
		System.out.println(childBeanFactory.containsBeanDefinition("person"));

		//输出false 代表没有这个bean,也代表ListableBeanFactory不会输出Parent的Bean
		System.out.println("ListableBeanFactory查找"+childBeanFactory.containsBean("person"));

		//先要通过ConfigurableBeanFactory 配置个ParentBeanFactory
		ConfigurableBeanFactory configurableBeanFactory = childContext.getBeanFactory();
		configurableBeanFactory.setParentBeanFactory(parentBeanFactory);


		//再从HierarchicalBeanFactory中去查找才会找到parentBeanFactory中的Bean
		HierarchicalBeanFactory hierarchicalBeanFactory = childContext.getBeanFactory();
		//输出true 代表有这个bean,也代表HierarchicalBeanFactory会输出Parent的Bean
		System.out.println("HierarchicalBeanFactory查找："+hierarchicalBeanFactory.containsBean("person"));



		//去parentBeanFactory中获取bean别名集合
		String[] childPersonAlias = childBeanFactory.getAliases("person");
		//输出0
		System.out.println(childPersonAlias.length);


		//因为设置了parentBeanFactory 会去parentBeanFactory中查找,且支持别名查找
		System.out.println("isSingleton:"+childBeanFactory.isSingleton("johnperson"));

		//因为设置了parentBeanFactory 会去parentBeanFactory中查找
		System.out.println("isPrototype:"+childBeanFactory.isPrototype("person"));

		//输出Person类的 bean集合 为空
		System.out.println(childBeanFactory.getBeansOfType(Person.class));


		//通过BeanFactoryUtils类的方法可以获取parentFactory中的bean
		System.out.println("BeanFactoryUtils:" + BeanFactoryUtils.beansOfTypeIncludingAncestors(childBeanFactory, Person.class));

		//输出容器中BeanDefinition 的总数 只有当前beanFactory中的bean 为 ChineseFemaleSinger，Jane，Bibi
		System.out.println(childBeanFactory.getBeanDefinitionCount());

	}


}
