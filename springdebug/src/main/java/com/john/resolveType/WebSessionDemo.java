package com.john.resolveType;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/8
 */
public class WebSessionDemo {


	public static void main(String[] args) {

		WebSessionDetails webSessionDetails =new WebSessionDetails();

		//报ClassCastException
		WebClientDetail sessionDetails = webSessionDetails.getAttribute("ss");

		System.out.println(sessionDetails);
	}

	interface WebSession {


			Map<String, Object> getAttributes();

			//泛型方法
			@Nullable
			default <T>  T getAttribute(String name) {
				return (T) this.getAttributes().get(name);
			}
	}

	static  class WebSessionDetails implements WebSession{

		@Override
		public Map<String, Object> getAttributes() {
			 Map<String, Object> map =new HashMap<>();
			 map.put("ss",new WebSessionDetails());
			 return  map;
		}
	}

	static class WebClientDetail{

	}
}
