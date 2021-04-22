package com.john.resolveType;

import java.util.Date;

/**
 * @Description: 泛型擦除
 * @Author: johnwonder
 * @Date: 2021/3/30
 */
public class DateInterval extends  Pair<Date>{

	public Date getSecond(){
		return (Date) super.getSecond().clone();
	}
}
