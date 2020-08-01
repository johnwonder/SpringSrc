package com.john.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Properties;

/**
 * @Description: Profile测试
 * @Author: johnwonder
 * @Date: 2020/7/7
 */
public class ProfileApp {

	public  static void main(String[] args){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 手动设置激活的Profiles
		ConfigurableEnvironment environment = context.getEnvironment();


		//公众号里写过这个文章
		//environment.getPropertySources().addFirst();

		//set会把ActiveProfiles清空 再添加
		//add 是直接添加到 activeProfiles set集合中
		// activeProfiles是 一个 LinkedHashSet
		//environment.setActiveProfiles("dev", "test1", "test2");
		// environment.setDefaultProfiles("",""); // 也可以设置默认的  只是一般都不这么干~

		//设置了actieProfiles 那么defaultProfiles就不会生效
		//environment.setActiveProfiles("dev3");

		environment.setDefaultProfiles("default1");
		//打印当前系统属性列表
		//-Dspring.profiles.active=XXX 属于SystemProperties
		System.out.println(environment.getSystemProperties());

		System.out.println(environment.getSystemProperties().get("spring.profiles.active"));

		//打印当前系统环境变量
		System.out.println(environment.getSystemEnvironment());

		//自定义Environment https://blog.csdn.net/mytt_10566/article/details/83964151
		//https://www.kancloud.cn/george96/springboot/613631

		context.register(RootConfig.class);
		context.refresh();


		//@ProfileCondition的原理是 @Conditional注解
		String[] activeProfiles = environment.getActiveProfiles();
		String[] defaultProfiles = environment.getDefaultProfiles();
		System.out.println(StringUtils.arrayToCommaDelimitedString(activeProfiles)); //{}
		System.out.println(StringUtils.arrayToCommaDelimitedString(defaultProfiles)); //{default}
		System.out.println(context.getBean("person"));

		//@Profile注解 是基于 Conditional的
		//关于Conditional的使用 请看 https://blog.csdn.net/xcy1193068639/article/details/81491071

		//@Profile有个父注解@Conditional，支持传入一个多个实现Condition接口的类
		//带有matches方法

		//todo @Conditional 是什么时候生效的，或者说在容器的什么阶段起作用的

		//https://www.cnblogs.com/dongma/p/10290181.html
		//1. ConfigurationClassParser  processConfigurationClass 处理ConfigurationClass的时候
		//2。ConfigurationClassBeanDefinitionReader loadBeanDefinitionsForBeanMethod 通过Bean方法 加载Bean的时候

		//3。 AnnotatedBeanDefinitionReader 调用doRegisterBean 注册bean的时候

		//扫描器
		//4。ClassPathBeanDefinitionScanner 继承自 ClassPathScanningCandidateComponentProvider
		// 调用doScan方法
		  //1) ComponentScanAnnotationParser 里 调用parse方法的时候 ，一开始就实例化一个ClassPathBeanDefinitionScanner
		 // 2） ComponentScanBeanDefinitionParser 调用parse方法的时候 通过configureScanner 返回一个ClassPathBeanDefinitionScanner


		//因为我们这边的@Profile是在@Configuration 里定义的 Bean方法上的。
		//所以应该是在ConfigurationClassBeanDefinitionReader里去判断的
	}

	private static  void replaceProperty() throws FileNotFoundException,IOException {

		String a = "{name}{age}{sex}";
		String b = "{name{age}{sex}}";
		PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
		InputStream in = new BufferedInputStream(new FileInputStream(new File("/Users/zhangjiong/code/SpringSrc/springdebug/src/main/resources/test01.properties")));
		Properties properties = new Properties();
		properties.load(in);

		System.out.println("替换前:" + a);

		//https://blog.csdn.net/qq_32916805/article/details/78569931
		//貌似就不能使用method reference
		//https://www.cnblogs.com/daren-lin/p/java-method-reference.html
		//idea 提示的有问题
		System.out.println("替换后:" + propertyPlaceholderHelper.replacePlaceholders(a, (placeholderName) -> properties.getProperty(placeholderName)));
		System.out.println("====================================================");
		System.out.println("替换前:" + b);
		System.out.println("替换后:" + propertyPlaceholderHelper.replacePlaceholders(b, new PropertyPlaceholderHelper.PlaceholderResolver() {
			@Override
			public String resolvePlaceholder(String placeholderName) {
				String value = properties.getProperty(placeholderName);
				return value;
			}
		}));
	}
}
