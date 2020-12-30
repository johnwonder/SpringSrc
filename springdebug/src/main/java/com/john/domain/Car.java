package com.john.domain;

public class Car {

	private String brand;

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return  "car and brand is" +brand;
	}
}
