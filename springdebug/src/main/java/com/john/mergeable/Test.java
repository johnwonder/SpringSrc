package com.john.mergeable;

import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.beans.factory.support.ManagedSet;

import java.util.*;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/18
 */
public class Test {

	public static void main( String[] args ) {


		double d  = 1.75;

		System.out.println(d);
		//允许重复
		ManagedList<String> managedList = new ManagedList<>();
		managedList.setMergeEnabled(true);
		managedList.add("ss");
		managedList.add("cc");

		List<String>  stringList = new ArrayList<>();
		stringList.add("ss");

		List<String> mergedList = managedList.merge(stringList);

		System.out.println("list:"+mergedList);


		//不允许重复  LinkedHashSet 有序
		//https://www.cnblogs.com/bcl88/p/11469845.html
		ManagedSet<String> managedSet = new ManagedSet<>();
		managedSet.setMergeEnabled(true);
		managedSet.add("ss");
		managedSet.add("cc");

		Set<String> stringSet = new HashSet<>();
		stringSet.add("cc");


		Set<String> mergedSet = managedSet.merge(stringSet);

		System.out.println("set:"+mergedSet);

		//不允许重复 LinkedHashMap  有序
		//https://www.cnblogs.com/lyhc/p/10743550.html
		ManagedMap<String,String> managedMap = new ManagedMap<>();
		managedMap.setMergeEnabled(true);
		managedMap.put("ss","ss");
		managedMap.put("cc","cc");

		Map<String,String>  stringMap = new LinkedHashMap<>();
		stringMap.put("cc","cc");


		Map<String,String> mergedMap = (Map<String,String>)managedMap.merge(stringMap);

		System.out.println("map:"+mergedMap);

		//不允许重复
		ManagedProperties managedProperties =new ManagedProperties();
		managedProperties.setMergeEnabled(true);
		managedProperties.setProperty("ss","ss");
		managedProperties.setProperty("cc","cc");


		Properties properties = new Properties();
		properties.put("ss","ss");

		ManagedProperties mergedProperties = (ManagedProperties)managedProperties.merge(properties);

		System.out.println("properties:"+mergedProperties);

		//https://www.cnblogs.com/q2546/p/11394723.html
		//list和set的区别
	}
}
