package org.wonder.frame.importandfilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/18
 */
@Configuration
public class ImportConfig {

	@Bean
	ImportBean importBean(){
		return new ImportBean();
	}
}
