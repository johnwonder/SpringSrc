package com.john.javabase;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/13
 */
public class TestInheritInterface {

	public static void main(String[] args) {

		ResourceLoader resourceLoader = new MyResourceLoader();

		if(resourceLoader instanceof  ResourcePatternResolver){
			System.out.println("is ResourcePatternResolver");
		}
	}

	public  static  interface  ResourcePatternResolver{

	}

	public  static  interface  ResourceLoader{

	}

	public static  class  MyResourceLoader implements ResourceLoader, ResourcePatternResolver{

	}
}
