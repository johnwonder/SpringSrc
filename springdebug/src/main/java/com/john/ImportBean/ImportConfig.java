package com.john.ImportBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */

@ComponentScan("com.john.ImportBean")
@Import(BeanDefinitionRegistrar.class)
public class ImportConfig {
}
