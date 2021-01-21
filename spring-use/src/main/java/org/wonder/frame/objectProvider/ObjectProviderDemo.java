package org.wonder.frame.objectProvider;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/16
 */
public class ObjectProviderDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext=  new ClassPathXmlApplicationContext();

		applicationContext.setConfigLocation("spring/spring-config.xml");
		applicationContext.refresh();

		ObjectProvider<UserObject> userObjectObjectProvider = applicationContext.getBeanProvider(ResolvableType.forType(UserObject.class));

	    List<UserObject> userObjects = userObjectObjectProvider.stream().collect(Collectors.toList());
		System.out.println(userObjects);
	    //会报NoUniqueBeanDefinitionException
	    //userObjectObjectProvider.ifAvailable(System.out::println);
		//UserObject userObject = userObjectObjectProvider.getIfAvailable();

		//如果是唯一的 才会输出
		userObjectObjectProvider.ifUnique(System.out::println);

		//https://www.cnblogs.com/lxqiaoyixuan/p/7156944.html
		//支持迭代器
		Iterator<UserObject> userIterator = userObjectObjectProvider.iterator();
		//迭代器for循环
		for (Iterator iter = userIterator; iter.hasNext();) {
			UserObject user = (UserObject)iter.next();
			System.out.println(user);
		}
		//迭代器while循环
		while(userIterator.hasNext()){
			UserObject user = (UserObject) userIterator.next();
			System.out.println(user);
		}

		//直接支持for语法
		for (UserObject userObject : userObjectObjectProvider){

			System.out.println(userObject);
		}

		//https://www.cnblogs.com/yangzhilong/p/10985658.html
		//https://blog.csdn.net/sl1992/article/details/100149187
		Spliterator<UserObject> userObjectSpliterator = userObjectObjectProvider.spliterator();
		userObjectSpliterator.forEachRemaining((UserObject user) -> {
			System.out.println(Thread.currentThread().getName() + "--" + user);
		});
	}
}
