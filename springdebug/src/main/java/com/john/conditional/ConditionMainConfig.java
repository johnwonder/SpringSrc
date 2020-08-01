package com.john.conditional;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/8
 */
@Configuration
@Import({ConditionBeanConfig1.class, ConditionBeanConfig2.class})
public class ConditionMainConfig {


}
