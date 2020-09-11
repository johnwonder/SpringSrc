package com.john.SPI;


import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class Test {

	//https://www.jianshu.com/p/3a3edbcd8f24
	public static void main(String[] args) {
		Iterator<SPIService> providers = Service.providers(SPIService.class);
		ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

		while(providers.hasNext()) {
			SPIService ser = providers.next();
			ser.execute();
		}
		System.out.println("--------------------------------");
		Iterator<SPIService> iterator = load.iterator();
		while(iterator.hasNext()) {
			SPIService ser = iterator.next();
			ser.execute();
		}
	}
}
