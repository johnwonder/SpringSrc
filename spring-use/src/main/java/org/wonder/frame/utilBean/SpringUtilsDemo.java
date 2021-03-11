package org.wonder.frame.utilBean;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.*;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/9
 */

public class SpringUtilsDemo {

	public static void main(String[] args) {

		DemoClass demo = new DemoClass();
		Assert.notNull(demo.getList(), "the list can't be null");

		beansUtils(demo);
		classUtils();
		systemPropertyUtils();
		fileCopyUtils();
		aop(demo);
		reflection();
		ensure();
		collections();
		serialize();

	}
	private static void ensure() {
		int counter = 2;
		Assert.state(counter == 2, () -> "the counter should be 2 or more. Was " + counter);
		Assert.hasText("Hello, world!", () -> "this string should be a non-null, non-empty String");
	}

	private static void reflection() {

		ReflectionUtils.doWithFields(DemoClass.class, field -> System.out.println("field = " + field.toString()));
		ReflectionUtils.doWithMethods(DemoClass.class, method -> System.out.println("method = " + method.toString()));

		Field list = ReflectionUtils.findField(DemoClass.class, "list");
		System.out.println((Objects.requireNonNull(list).toString()));

		ResolvableType rt = ResolvableType.forField(list);
		System.out.println((rt.toString()));
	}

	private static void aop(DemoClass demoClass) {
		Class<?> targetClass = AopUtils.getTargetClass(demoClass);
		System.out.println(("Class<?> is " + targetClass));
		System.out.println(("is AOP proxy? " + AopUtils.isAopProxy(demoClass)));
		System.out.println(("is CGlib proxy? " + AopUtils.isCglibProxy(demoClass)));
	}

	private static void collections() {
		Collection<String> names = Arrays.asList("Tammie", "Kimly", "Josh");
		boolean contains = CollectionUtils.containsAny(names, Arrays.asList("Josh"));
		Assert.state(contains, () -> "one or more of the names in " + names.toString() + " should be present");
	}

	private static void serialize() {
		Customer in = new Customer(593232329, "Josh");
		byte[] bytes = SerializationUtils.serialize(in);
		Customer out = (Customer) SerializationUtils.deserialize(bytes);
		Assert.state(out.getId() == in.getId() && out.getName().equals(in.getName()),
				() -> "the " + Customer.class.getName() + " did not serialize correctlyy");
	}

	private static void fileCopyUtils() {
		Resource cpr = new ClassPathResource("/application.properties");
		try (Reader r = new InputStreamReader(cpr.getInputStream())) {
			String contents = FileCopyUtils.copyToString(r);
			System.out.println(("application.properties contents: " + contents));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void systemPropertyUtils() {
		String resolvedText = SystemPropertyUtils.resolvePlaceholders("my home directory is ${user.home}");
		System.out.println(("resolved text: " + resolvedText));
	}

	private static void classUtils() {
		Constructor<DemoClass> demoClassConstructor = ClassUtils.getConstructorIfAvailable(DemoClass.class);
		System.out.println(("demoClassConstructor: " + demoClassConstructor));
		try {
			DemoClass demoClass = demoClassConstructor.newInstance();
			System.out.println(("newInstance'd demoClass: " + demoClass));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void beansUtils(DemoClass demo) {
		PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(demo.getClass());
		for (PropertyDescriptor pd : descriptors) {
			System.out.println(("pd: " + pd.getName()));
		}
	}

	public static class DemoClass {

//		@PostConstruct
//		public void begin() {
//			System.out.println(("begin()"));
//		}

		private final List<Map<String, Object>> list = new ArrayList<>();

		public List<Map<String, Object>> getList() {
			return list;
		}
	}
}
