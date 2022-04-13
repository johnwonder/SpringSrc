package com.john.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class BeanAliasNameDemo {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-alias.xml");
		SchoolName school=(SchoolName)context.getBean("seniorSchool");

		System.out.println("school name:"+school.getName());
	    String[] aliases =	context.getAliases("school");
		System.out.println(String.format("school的别名有:%s",String.join(",", aliases)));

		//school3如果name 和Id一样 那么别名就没有了
		//因为 registry.registerAlias(beanName, alias); 里会判断是否和beanName一样
		//主要逻辑在DefaultBeanDefinitionDocumentReader.processBeanDefinition
		String[] school3Aliases =	context.getAliases("school3");
		System.out.println(String.format("school3的别名有:%s",String.join(",", school3Aliases)));

		SchoolName school2=(SchoolName)context.getBean("school2");
		System.out.println("school name:"+school2.getName());

		//直接获取不到
//		SchoolName childSchool=(SchoolName)context.getBean("childSchool");
//		System.out.println("childSchool  name:"+childSchool.getName());

		//嵌套bean 不会注册别名 反而别名可以和存在的bean名称一样
		//嵌套Bean 会作为父bean 的属性beandefinition存在 而不会注册到beandefinitionMap中  在父bean实例化的时候作为属性填充
		//填充的时候会判断容器内部是否存在该名称的bean
        SchoolName school3=(SchoolName)context.getBean("school3");
		System.out.println("childSchool  name:"+school3.getChildSchool().getName());
	}

}
