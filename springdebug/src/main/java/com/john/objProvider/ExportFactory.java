package com.john.objProvider;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/8
 */
@Component
public class ExportFactory {

	//https://www.orcode.com/question/976321_ke4a84.html
	//注入的是一个ObjectFactory
	@Autowired
	@Qualifier("exportFactory")
	ObjectFactory<?> exportFactory;

	public ObjectFactory<?> getExportFactory() {
		return exportFactory;
	}
}
