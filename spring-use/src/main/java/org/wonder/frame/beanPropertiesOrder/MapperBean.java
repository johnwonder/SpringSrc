package org.wonder.frame.beanPropertiesOrder;

/**
 * @Description: SpringSrc
 * @Author: zhangjiong
 * @Date: 2020/4/14
 */
public class MapperBean {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSessionTemplate aqlSessionTemplate;

	public SqlSessionTemplate getAqlSessionTemplate() {
		return aqlSessionTemplate;
	}


	public SqlSessionFactory getSqlSessionFactory() {
		return  (this.aqlSessionTemplate != null ? this.aqlSessionTemplate.getSqlSessionFactory() : null);
	}


	public void setSqlSessionFactory(SqlSessionProperty sqlSessionFactory) {
		System.out.println("sqlSessionFactory");
		this.aqlSessionTemplate = new SqlSessionTemplate();

	}

	public void setAqlSessionTemplate(SqlSessionTemplate aqlSessionTemplate) {

		System.out.println("aqlSessionTemplate");

		if(this.aqlSessionTemplate != null)
			System.out.println("aqlSessionFactory 已存在,会被覆盖");
		this.aqlSessionTemplate = new SqlSessionTemplate();

	}

}
