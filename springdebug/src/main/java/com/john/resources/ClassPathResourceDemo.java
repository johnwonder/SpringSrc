package com.john.resources;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class ClassPathResourceDemo {

	//https://blog.csdn.net/mm_bit/article/details/50372229
	public static void main(String[] args) {
		try {
			//URL url = new URL("jar:file:/Users/zhangjiong/code/SpringSrc/springdebug/lib/bt-pms-1.0.jar!/BOOT-INF/classes/application.yml");

			//Resource resource = ResourceUtils.isFileURL(url) ? new FileUrlResource(url) : new UrlResource(url);

			ClassPathResource resource = new ClassPathResource("/org/yaml/snakeyaml/DumperOptions.class");

			int  num = resource.getInputStream().available();

			System.out.println(num);

		}catch (MalformedURLException e){

		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
