package org.wonder.frame.beanDefinitionBuilder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/2
 */
public class PersonBeanRegiser implements BeanFactoryAware {

	private BeanFactory beanFactory;

	@PostConstruct
	public void register(){
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		builder.addPropertyValue("name", "张三");
		builder.addPropertyValue("age", 20);

		ManagedMap<String,String> posts = new ManagedMap<>();
		posts.put("post1","teacher");
		posts.put("post2","javaer");
		builder.addPropertyValue("posts",posts);

		ManagedMap<String,String> newPosts = new ManagedMap<>();
		newPosts.setMergeEnabled(true);
		newPosts.put("post1","programmer"); //基于linkedhashmap 所以还是合并不了
		newPosts.put("post2","gopher");
		builder.addPropertyValue("posts",newPosts);

		ManagedList<String> ranks = new ManagedList<>();
		ranks.setMergeEnabled(true);
		ranks.add("ranks1");
		ranks.add("ranks2");
		builder.addPropertyValue("ranks",ranks);

		ManagedList<String> newRanks = new ManagedList<>();
		newRanks.setMergeEnabled(true);
		newRanks.add("ranks1");
		newRanks.add("ranks2");
		builder.addPropertyValue("ranks",newRanks);


		builder.getBeanDefinition().setAttribute("sex","man");
		//重点
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) this.beanFactory;
		registry.registerBeanDefinition("person", builder.getBeanDefinition());
	}

	/**
	 *
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PersonBeanRegiser.class);
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
	}
}
