package com.john.construct;

import java.util.Date;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/20
 */
public class FactoryObject {

	public DmzService getDmz(String name, int age, Date birthDay, OrderService orderService) {

		 return new DmzService(orderService,name);
	}


//	public DmzService getDmz(String name,OrderService orderService, String sex){
//
//		return new DmzService(orderService,name);
//	}

	public DmzService getDmz(OrderService orderService,String name) {

		return new DmzService(orderService,name);
	}

}
