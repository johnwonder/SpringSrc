package com.john.serviceLocatorBean;

import javax.inject.Named;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
@Named
public class XmlParser implements Parser {

	@Override
	public String parse(String content) {
		 return  "cccc";
	}
}
