package org.wonder.frame.genericDependency;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/20
 */
public class BaseService<T> {

	public BaseDao baseDao;

	public void service() {
		System.out.println(baseDao);
		baseDao.say();
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	//必须要有@Autowired
	@Autowired
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
}
