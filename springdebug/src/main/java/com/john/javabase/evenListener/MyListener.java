package com.john.javabase.evenListener;

import java.util.Map;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
//自定义监听器，继承自定义监听接口
class MyListener implements MyEventListener
{
	public Map<Integer, String> map =null;
	public int i=0;

	public MyListener(Map<Integer, String>  map)
	{
		this.map = map;
		MyEventSource mes = new MyEventSource();
		mes.addMyEventListener(this);
		mes.setName("niu");
	}

	//实现接口中的方法
	public void handleEvent(MyEvent me)
	{
		System.out.println("me.getSource()  "+me.getSource());
		System.out.println("me.getsName()  "+me.getsName());
		//此处可以将写，将监听到的对象存入map中
		map.put(++i, me.getsName());
	}
}
