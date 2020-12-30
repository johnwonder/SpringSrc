package com.john.propertyEditor;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/29
 */
public class Car {
	private int maxSpeed;
	public String brand;
	private double price;
	//省略get/setter


	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car{" +
				"maxSpeed=" + maxSpeed +
				", brand='" + brand + '\'' +
				", price=" + price +
				'}';
	}
}

