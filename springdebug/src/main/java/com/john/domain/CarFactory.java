package com.john.domain;

public class CarFactory {
	//非静态方法
	public Car createCar(Brand brand){

		System.out.println(brand);
		Car car = new Car();
		car.setBrand("BMW");
		return car;
	}

	//静态方法
	public static Car createStaticCar(Brand brand){

		System.out.println(brand);
		Car car = new Car();
		return car;
	}
}
