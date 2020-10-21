package com.john.xmlconfig;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/18
 */
public class TeacherConverter implements Converter<String,Teachers> {

	@Nullable
	@Override
	public Teachers convert(String source) {
		Teachers t = new Teachers();
		t.setName(source);
		return t;
	}
}
