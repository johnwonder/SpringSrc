package com.john.applicationContext;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/6
 */
@Component("index")
public class IndexService {

	private ArticleService b;

	//todo 通过AutowiredAnnotationBeanPostProcessor 注入构造函数
	public IndexService(ObjectProvider<ArticleService> b) {
		this.b = b.getIfAvailable();
	}

	@Override
	public String toString() {
		return "IndexService{" +
				"b=" + b +
				'}';
	}
}
