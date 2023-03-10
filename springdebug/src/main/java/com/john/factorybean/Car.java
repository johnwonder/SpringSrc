package com.john.factorybean;

public class Car {

	private   int maxSpeed ;
	private  String brand ;
	private   double price ;

	public double getPrice() {
			return price;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
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