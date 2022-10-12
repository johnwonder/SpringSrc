package com.john.envrionment;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/8/31
 */
public class ProfileDemo {

	public static void main(String[] args) {

		//抽象类还是可以通过这种类似匿名对象的方式
		Environment env = new AbstractEnvironment() {

		};
		System.out.println(env.acceptsProfiles(defaultProfile()));
	}


	private static Profiles defaultProfile() {

		return Profiles.of();
	}
}
