package com.john.javabase.evenListener;

import java.util.EventListener;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public interface DoorListener extends EventListener {
	void onMessage(String message);
}
