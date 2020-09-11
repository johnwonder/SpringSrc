package com.john.serviceLocatorBean;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
public interface ParserFactory {
	Parser getParser(String beanName);
}
