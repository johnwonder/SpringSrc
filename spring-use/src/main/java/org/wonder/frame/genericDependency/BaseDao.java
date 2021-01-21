package org.wonder.frame.genericDependency;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/20
 */
public class BaseDao<T> {
	public void say() {
		System.out.println("baseDao say");
	}
}
