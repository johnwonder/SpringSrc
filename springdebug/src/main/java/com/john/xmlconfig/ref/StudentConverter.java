package com.john.xmlconfig.ref;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/18
 */
//https://cloud.tencent.com/developer/article/1497687
	//https://www.jianshu.com/p/0d8c6d0b5e0d
	//Converter
public class StudentConverter implements Converter<String,Students> {

	@Nullable
	@Override
	public Students convert(String source) {
		Students t = new Students();
		t.setName(source);
		return t;
	}
}
