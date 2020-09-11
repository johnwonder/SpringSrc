package com.john.serviceLocatorBean;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
@Named
public class JsonParser implements Parser {

	@Override
	public String parse(String content) {
		 return  "ssss";
	}
}
