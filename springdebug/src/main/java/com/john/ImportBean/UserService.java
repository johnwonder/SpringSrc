package com.john.ImportBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */
@Component
public class UserService {

	@Autowired
	@Qualifier("UserMapper")
	private UserMapper userMapper;

//	@Autowired
//	private OrderMapper orderMapper;

	public void test(){

		System.out.println("userMapper  "+userMapper);
		userMapper.selectById();
		//orderMapper.selectById();
	}
}
