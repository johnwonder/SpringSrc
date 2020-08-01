package com.john.conditional;

import com.john.profile.RootConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/8
 */
public class ConditionApp {

	public  static void main1(String[] args){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionMainConfig.class);

		//输出name->路人甲Java
		context.getBeansOfType(String.class).forEach((beanName, bean) -> {
			System.out.println(String.format("%s->%s", beanName, bean));
		});


		//https://www.cnblogs.com/dongma/p/10290181.html
		//1. ConfigurationClassParser  processConfigurationClass 解析ConfigurationClass的时候
		//2。ConfigurationClassBeanDefinitionReader loadBeanDefinitionsForBeanMethod 通过Bean方法 注册Bean的时候

		//3。 AnnotatedBeanDefinitionReader 调用doRegisterBean 注册bean的时候

		//扫描器
		//4。ClassPathBeanDefinitionScanner 继承自 ClassPathScanningCandidateComponentProvider
		// 调用doScan方法
		//1) ComponentScanAnnotationParser 里 调用parse方法的时候 ，一开始就实例化一个ClassPathBeanDefinitionScanner
		// 2） ComponentScanBeanDefinitionParser 调用parse方法的时候 通过configureScanner 返回一个ClassPathBeanDefinitionScanner

		//因为我们这边的@Profile是在@Configuration 里定义的 Bean方法上的。
		//所以应该是在ConfigurationClassBeanDefinitionReader里去判断的
	}
}
