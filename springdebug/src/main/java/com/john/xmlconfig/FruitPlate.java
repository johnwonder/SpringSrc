package com.john.xmlconfig;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/8
 */
public abstract class FruitPlate {
	// 抽象方法获取新鲜水果
	protected abstract Fruit getFruit(String fruitName);
}
