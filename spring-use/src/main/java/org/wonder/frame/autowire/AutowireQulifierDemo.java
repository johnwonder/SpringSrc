package org.wonder.frame.autowire;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/5/6
 */
@ComponentScan
@Configuration
public class AutowireQulifierDemo {

	public static void main(String[] args) throws NoSuchFieldException {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();


		applicationContext.register(AutowireQulifierDemo.class);

//		ConstructorArgumentValues cavs1 = new ConstructorArgumentValues();
//		cavs1.addGenericArgumentValue("JUERGEN");
//		RootBeanDefinition person1 = new RootBeanDefinition(Person.class, cavs1, null);
//		person1.addQualifier(new AutowireCandidateQualifier(TestQualifier.class));
//		applicationContext.registerBeanDefinition("JUERGEN", person1);

		ConstructorArgumentValues cavs2 = new ConstructorArgumentValues();
		cavs2.addGenericArgumentValue("MARK");
		RootBeanDefinition person2 = new RootBeanDefinition(Person.class, cavs2, null);
//		person1.addQualifier(new AutowireCandidateQualifier(TestQualifier.class));
		applicationContext.registerBeanDefinition("MARK", person2);

		DependencyDescriptor qualifiedDescriptor = new DependencyDescriptor(
				QualifiedTestBean.class.getDeclaredField("qualified"), false);
//		System.out.println(applicationContext.getBeanFactory().isAutowireCandidate("JUERGEN", qualifiedDescriptor));

		applicationContext.refresh();

		System.out.println(applicationContext.getBean(QualifiedTestBean.class));
	}

	@Bean
	@TestQualifier
	Person person(){
		Person person =new Person("john");
		return  person;
	}


}
