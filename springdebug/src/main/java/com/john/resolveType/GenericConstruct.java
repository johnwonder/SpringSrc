package com.john.resolveType;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/19
 */
public class GenericConstruct {

	String name;
	//泛型构造函数
	//https://www.cnblogs.com/liululee/p/10943520.html
	public <T extends Rankble> GenericConstruct(T s) {

		this.name =s.getPerson();

	}
}
