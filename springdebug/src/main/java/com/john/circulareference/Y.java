package com.john.circulareference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/28
 */
@Component
public class Y {
	@Autowired
	X x;

	public Y(){
		System.out.println("Y create");
	}
}
