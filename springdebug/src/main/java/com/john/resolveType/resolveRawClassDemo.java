package com.john.resolveType;

import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/18
 */
public class resolveRawClassDemo<T> {

	public static void main(String[] args) {


		ResolvableType hashMapType = ResolvableType.forClass(HashMap.class);
		System.out.println(hashMapType.hasGenerics());


		//打印出Object
//		System.out.println(ResolvableType.forClass(null));
//
//		ResolvableType resolvableRawClass = ResolvableType.forRawClass(Parent.class);
//
//		ResolvableType resolvableClass = ResolvableType.forClass(Parent.class);
//
//
//		//System.out.println(resolvableType.getRawClass());
//		System.out.println(resolvableRawClass.isAssignableFrom(Children.class));
//		System.out.println(resolvableClass.isAssignableFrom(Children.class));
//
//
//		ResolvableType resolvableChildren = ResolvableType.forRawClass(Children.class);
//		//class org.springframework.core.ResolvableType
//		System.out.println(resolvableChildren.getClass());
//		//class com.john.resolveType.Children
//		System.out.println(resolvableChildren.getRawClass());

		//https://cloud.tencent.com/developer/article/1656249
		HashMap<String,String> hashMap1 = new HashMap<>();
		ResolvableType resolvableMap = ResolvableType.forClass(getHashMapClass(hashMap1).getClass());
		//获取泛型参数
		resolvableMap.getGenerics();
		System.out.println("HashMap的 getGenerics："+resolvableMap.getGeneric(0));
		//https://blog.csdn.net/whoami_i/article/details/94021759
		//System.out.println(resolvableMap.resolveGenerics().length);
		//class java.util.HashMap
		System.out.println("resolvableMap.getType()结果是："+resolvableMap.getType());
		System.out.println((resolvableMap.getType() instanceof ParameterizedType));


		// 获取到ResolveMap继承的HashMap所构建的一个ResolvableType，会带用泛型<String, Integer>
		ResolvableType resolvableType = ResolvableType.forClass(IBase.class, BaseClass.class);
		ResolvableType[] generics = resolvableType.getGenerics();
		for (ResolvableType generic : generics) {
			// 程序打印：
			// class java.lang.String
			// class java.lang.Integer
			System.out.println("ResolveMap的泛型类型为："+generic.getType());
		}

		try{
			ResolvableType resolvableMapParam = ResolvableType.forMethodParameter(resolveRawClassDemo.class.getDeclaredMethod("getHashMapClass",HashMap.class),0);

			//java.util.HashMap<java.lang.String, java.lang.String>
			System.out.println("resolvableMapParam的Type是："+ resolvableMapParam.getType());
			System.out.println("resolvableMapParam 是否是ParameterizedType："+(resolvableMapParam.getType() instanceof ParameterizedType));

			//打印出HashMap
			System.out.println(resolvableMapParam.getRawClass());
			//只有对象才是类的实例
			//System.out.println("resolvableMapParam 是否是ParameterizedType："+ (resolvableMapParam.getType() instanceof HashMap));

		}
		catch (NoSuchMethodException e){

			e.printStackTrace();
		}


		//获取泛型父类
		//java.util.HashMap<java.lang.String, java.lang.String>
		Type resolveMapType =ResolveMap.class.getGenericSuperclass();
		System.out.println(resolveMapType);
		System.out.println((resolveMapType instanceof ParameterizedType));
		//System.out.println(resolvableMap.getGenerics()[0].getRawClass());
		//System.out.println(ResolvableType.forRawClass(List.class));
	}

	private static class ResolveMap extends  HashMap<String,Integer> {

	}

	private static class BaseClass implements IChild {

	}

	private static interface IBase<A,B> {

	}

	private static interface IChild<A extends String,B> extends  IBase<A,B> {

	}

	public static  HashMap<String,String> getHashMapClass(HashMap<String,String> hashMap){

		return hashMap;
	}

	//https://blog.csdn.net/weixin_43819113/article/details/91042598
	//泛型方法
	private <T> String getPerson(T s){

		return  "";
	}
}
