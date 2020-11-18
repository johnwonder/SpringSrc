package com.john.javabase.evenListener;

import java.util.EventListener;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
//定义自定义监听器接口，继承EventListener
interface MyEventListener extends EventListener
{
	void handleEvent (MyEvent me);
}
