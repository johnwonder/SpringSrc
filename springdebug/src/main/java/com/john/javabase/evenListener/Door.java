package com.john.javabase.evenListener;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
/**
 * Door
 */
public class Door {

	private DoorListener listener;

	public void addListener(DoorListener doorListener) {
		this.listener = doorListener;
	}

	public void send() {
		for (int i = 0; i < 10; i++) {
			listener.onMessage("open the door");
		}
	}

}
