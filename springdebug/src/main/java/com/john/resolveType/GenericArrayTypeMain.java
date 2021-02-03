package com.john.resolveType;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/19
 */
public class GenericArrayTypeMain<T> {
	T[] t1;

	T[][] t2;

	List<T> list;

	List<String>[] stringListArray;

	String[][] stringArray;

	//https://cloud.tencent.com/developer/article/1656249
	public static void main(String[] args) {
		Class<GenericArrayTypeMain> genericArrayTypeMainClass = GenericArrayTypeMain.class;
		Field[] declaredFields = genericArrayTypeMainClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			String name = declaredField.getName();
			Type genericType = declaredField.getGenericType();
			if (genericType instanceof GenericArrayType) {
				System.out.println(name + "是一个泛型数组");
				Type genericComponentType = ((GenericArrayType) genericType).getGenericComponentType();

				System.out.println("是否是TypeVariable:"+(genericComponentType instanceof TypeVariable));
				System.out.println("是否是GenericArrayType:"+ (genericComponentType instanceof GenericArrayType));
				System.out.println("数组的元素类型为：" + genericComponentType);
			} else {
				System.out.println(name + "不是一个泛型数组");
			}
		}
	}
}
