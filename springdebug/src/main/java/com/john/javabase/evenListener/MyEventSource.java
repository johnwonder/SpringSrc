package com.john.javabase.evenListener;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
//定义事件源
class MyEventSource
{
	private Vector list=new Vector();
	private String   sName  = "";
	public MyEventSource()
	{
		super();
	}
	public void addMyEventListener(MyEventListener me)
	{
		list.add(me);
	}
	public void deleteMyEventListener(MyEventListener me)
	{
		list.remove(me);
	}
	public void notifyMyEvent(MyEvent me)
	{
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			//在类中实例化自定义的监听器对象,并调用监听器方法
			((MyEventListener) it.next()).handleEvent(me);
		}
	}
	public void setName(String str)
	{   boolean bool = false;
		if (str == null && sName != null)
			bool = true;
		else if (str != null && sName == null)
			bool = true;
		else if (!sName.equals(str))
			bool = true;
		this.sName = str;
		// 如果改变则执行事件
		if (bool)
			notifyMyEvent(new MyEvent(this, sName));
	}
	public String getsName()
	{   return sName;   }
}
