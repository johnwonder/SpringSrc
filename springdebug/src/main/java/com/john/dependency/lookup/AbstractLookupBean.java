package com.john.dependency.lookup;

import com.john.applicationContext.ArticleService;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/6
 */
@Component("article1")
public abstract  class AbstractLookupBean {

	//按照类型来查找
	@Lookup
	abstract ILookupBean testLookup(String args);

	@Override
	public String toString() {
		return "abstract article";
	}
}
