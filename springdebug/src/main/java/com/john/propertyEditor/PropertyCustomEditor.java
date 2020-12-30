package com.john.propertyEditor;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyEditorSupport;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/12/20
 */
public class PropertyCustomEditor {

	public static void main(String[] args) {
		Boss tb = new Boss();
		Car car =new Car();
		//tb.setCar(car);
		BeanWrapper bw = new BeanWrapperImpl(tb);
		bw.registerCustomEditor(Car.class, "car", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {

				Car car1  = new Car();
				car1.setBrand("prefix" + text);
				setValue(car1);
			}
		});

		bw.setAutoGrowNestedPaths(true);
		//bw.findCustomEditor(Car.class,"car[0]");
		bw.setPropertyValue("car[0]", "value");

		Car[] cars=  (Car[]) bw.getPropertyValue("car");
		System.out.println(cars.length);

		System.out.println(cars[0]);
	}
}
