package com.john.javabase.evenListener;

import java.util.EventObject;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
class MyEvent extends EventObject
{
	private Object obj;
	//此监听对象可以是自定义对象
	private String sName;
	public MyEvent(Object source,String sName)
	{
		super(source);
		this.obj=source;
		this.sName=sName;  }
	public Object getObj()
	{
		return obj;
	}
	public String getsName()
	{
		return sName;
	}
}
