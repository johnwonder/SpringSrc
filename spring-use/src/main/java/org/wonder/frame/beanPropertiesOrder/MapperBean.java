package org.wonder.frame.beanPropertiesOrder;

import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: zhangjiong
 * @Date: 2020/4/14
 */
public class MapperBean {

	private SqlSessionFactory sqlSessionFactory;
	private AqlSessionTemplate aqlSessionTemplate;

	public AqlSessionTemplate getAqlSessionTemplate() {
		return aqlSessionTemplate;
	}


	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setAqlSessionTemplate(AqlSessionTemplate aqlSessionTemplate) {

		System.out.println("aqlSessionFactory");

		if(this.aqlSessionTemplate != null)
			System.out.println("aqlSessionFactory 已存在,会被覆盖");
		this.aqlSessionTemplate = new AqlSessionTemplate();

	}


	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		System.out.println("sqlSessionFactory");
		this.aqlSessionTemplate = new AqlSessionTemplate();

	}
}
