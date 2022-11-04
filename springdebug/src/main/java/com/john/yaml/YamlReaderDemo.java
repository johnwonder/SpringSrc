package com.john.yaml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/14
 */
public class YamlReaderDemo {

	public static void main(String[] args) throws FileNotFoundException {

		Yaml yaml = new Yaml(new Constructor(UnitNode.class));
		InputStream inputStream = new FileInputStream("/Users/zhangjiong/code/SpringSrc/springdebug/src/main/resources/unit.yml");
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setCanonical(false);

		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		UnitNode unit = yaml.load(inputStream);

		System.out.println(unit);

//————————————————
//		版权声明：本文为CSDN博主「π大星的日常」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//		原文链接：https://blog.csdn.net/m0_73311735/article/details/126401914
	}

	private static void springRead(){
		YamlPropertiesFactoryBean yamlMapFactoryBean = new YamlPropertiesFactoryBean();
		yamlMapFactoryBean.setResources(new ClassPathResource("application.yml"));
		Properties properties = yamlMapFactoryBean.getObject();
		//获取yml里的参数


		String active = properties.getProperty("spring.profiles.active");
		System.out.println("active:"+active);
	}
}
