package com.john.converter;

import com.john.xmlconfig.School;
import com.john.xmlconfig.Students;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/13
 */
public class SchoolConverter implements Converter<School, String> {

	@Nullable
	@Override
	public String convert(School source) {

		return  source.getTeachers().getName();
	}
}
