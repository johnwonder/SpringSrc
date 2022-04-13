package com.john.javabase.function;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/23
 */
public class AnonymousFunctionDemo {

	//https://www.cnblogs.com/tiancai/p/6885293.html
	public static void main(String[] args) {

		int productPrice = new Product(){
			public int getPrice(){

				return 100;

			}
		}.getPrice();

		System.out.println(productPrice);
	}

}
