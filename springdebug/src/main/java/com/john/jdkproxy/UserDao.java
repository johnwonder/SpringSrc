package com.john.jdkproxy;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/9
 */
public class UserDao implements IUserDao {
	public void save() {
		System.out.println("----已经保存数据!----");
	}
}