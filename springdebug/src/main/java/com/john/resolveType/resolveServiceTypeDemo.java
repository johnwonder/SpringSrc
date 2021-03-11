package com.john.resolveType;

import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/19
 */
public class resolveServiceTypeDemo {

	public static void main(String[] args) {
		//ResolvableType resolvableType1 = ResolvableType.forClass(ABService.class);

		Method[] declaredMethods = resolveServiceTypeDemo.class.getDeclaredMethods();

		for (Method method : declaredMethods){

			try{
				System.out.println(resolveServiceTypeDemo.class.getMethod(method.getName(), method.getParameterTypes()));
			}
			catch (NoSuchMethodException e){

			}

		}

		//1
		//System.out.println(resolvableType1.getInterfaces().length);
		//显示问号
		//System.out.println(resolvableType1.getInterfaces()[0].getGeneric(1));

		//我们知道在Java中一切都是对象，我们一般所使用的对象都直接或间接继承自Object类。
		// Object类中包含一个方法名叫getClass，利用这个方法就可以获得一个对象的类型类。
		// 类型类指的是代表一个类型的类，因为一切皆是对象，
		// 类型也不例外，在Java使用类型类来表示一个类型。所有的类型类都是Class类的实例
		//https://www.cnblogs.com/Seachal/p/5371733.html
	    //Type serviveType = ABService.class;
		//is always false
		//System.out.println(serviceType instanceof  ParameterizedType);
		//获取泛型的类型参数名称
		System.out.println(ABService.class.getTypeParameters()[0].getName());

		Type parameterizedType = ABService.class.getGenericInterfaces()[0];
		//返回true
		System.out.println(parameterizedType instanceof  ParameterizedType);
//        Type genericType = parameterizedType.getActualTypeArguments()[1];

		//得到类型上的泛型   如果你的类可能被代理 可以通过ClassUtils.getUserClass(ABService.class)得到原有的类型
		ResolvableType resolvableType1 = ResolvableType.forClass(ABService.class);

		//resolvableType1.getSuperType(); 得到父类
		//以下是得到接口上的
		//返回null
		System.out.println(resolvableType1.getInterfaces()[0].getGeneric(1).resolve());

		//返回null
		//转换为某个类型（父类/实现的接口）  还提供了简便方法 asMap() /asCollection
		System.out.println(resolvableType1.as(Service.class).getGeneric(1).resolve());

		//获取原始类型为class com.john.resolveType.ABService
		System.out.println(resolvableType1.getRawClass());

		//数组
		ResolvableType resolvableArray = null;
		try {

			///得到字段的
			//class java.lang.String
			//ReflectionUtils.findField(GenricInjectTest.class, "cdService")
			//cdService的第二个泛型参数是： class java.lang.Double
			Field cdServiceField = GenricInjectTest.class.getDeclaredField("cdService");
			System.out.println("成员cdService的名称是:"+ cdServiceField.getName());
			ResolvableType cdServiceType =
					ResolvableType.forField(cdServiceField);

			System.out.println("cdService输出是："+cdServiceType);

			System.out.println("cdService的RawClass是："+cdServiceType.getRawClass());


			System.out.println("cdService的第二个泛型参数是： "+cdServiceType.getGeneric(1).resolve()); //得到某个位置的 如<C, D>  0就是C 1就是D

			//嵌套的
			//class java.lang.Integer
			ResolvableType resolvableType3 =
					ResolvableType.forField(GenricInjectTest.class.getDeclaredField("list"));
			System.out.println(resolvableType3.getGeneric(0).getGeneric(0).resolve());

			//Map嵌套
			ResolvableType resolvableType4 =
					ResolvableType.forField(ReflectionUtils.findField(GenricInjectTest.class, "map"));
			System.out.println("Map嵌套1" + resolvableType4.getGeneric(1).getGeneric(1).resolve());
			System.out.println("Map嵌套2" + resolvableType4.getGeneric(1, 0).resolve());

			//方法返回值
//		ResolvableType resolvableType5 =
//				ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(GenricInjectTest.class, "method"));
//		System.out.println(resolvableType5.getGeneric(1, 0).resolve());

			//构造器参数
			//得到Const类的构造函数
			ResolvableType resolvableType6 =
					ResolvableType.forConstructorParameter(ClassUtils.getConstructorIfAvailable(Const.class, List.class, Map.class), 1);
			System.out.println(resolvableType6.getGeneric(0).resolve());
			//获取到第二个泛型参数Map里的Map接口
			System.out.println(resolvableType6.getGeneric(1).resolve());
			System.out.println(resolvableType6.getGeneric(1, 1).resolve());


			//获取到array这个字段
			resolvableArray =
					ResolvableType.forField(GenricInjectTest.class.getDeclaredField("array"));
			System.out.println("是否是array:" + resolvableArray.isArray());
			System.out.println("array的ComponentType是:" + resolvableArray.getComponentType());

			System.out.println("array的ComponentType的泛型参数 是:" + resolvableArray.getComponentType().getGeneric(0).resolve());

		}
		catch (NoSuchFieldException e){

		}

		//自定义一个泛型数组 List<String>[]
		ResolvableType resolvableType8 = ResolvableType.forClassWithGenerics(List.class, String.class);
		ResolvableType resolvableType9 = ResolvableType.forArrayComponent(resolvableType8);
		System.out.println(resolvableType9.getComponentType().getGeneric(0).resolve());

		//比较两个泛型是否可以赋值成功
		System.out.println(resolvableArray.isAssignableFrom(resolvableType9));

		ResolvableType resolvableType10 = ResolvableType.forClassWithGenerics(List.class, Integer.class);
		ResolvableType resolvableType11 = ResolvableType.forArrayComponent(resolvableType10);
		System.out.println(resolvableType11.getComponentType().getGeneric(0).resolve());

		System.out.println(resolvableArray.isAssignableFrom(resolvableType11));
	}

	public  <T> String GenericMethod(List<T> params){

		return  "";
	}

	private HashMap<String, List<String>> method() {
		return null;
	}

	static class Const {
		public Const(List<List<String>> list, Map<String, Map<String, Integer>> map) {
		}

	}
}
