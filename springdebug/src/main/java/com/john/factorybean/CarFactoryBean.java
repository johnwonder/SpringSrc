package com.john.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean  implements FactoryBean<Car> {
	private  String carInfo;

	public  Car getObject()  throws  Exception {

		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.valueOf(infos[1]));
		car.setPrice(Double.valueOf(infos[2]));
		return car;
	}

	public  Class<Car> getObjectType(){
			return  Car.class ;

	}

	//返回的实例是同一个
	public   boolean  isSingleton()   {
			return   true;
		}

		public  String getCarInfo()  {
		return   this.carInfo ;
	}

		public   void  setCarInfo(String carInfo)   {
			this.carInfo = carInfo;
	}
}
