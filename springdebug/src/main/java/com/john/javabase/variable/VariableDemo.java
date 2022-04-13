package com.john.javabase.variable;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/9
 */
public class VariableDemo {

	public  int vacationDays;
	public static void main(String[] args) {

		int vacaitionDays;
		//局部变量必须初始化
		//System.out.println(vacaitionDays);

		//实例变量默认为0
		System.out.println(new VariableDemo().vacationDays);
	}
}
