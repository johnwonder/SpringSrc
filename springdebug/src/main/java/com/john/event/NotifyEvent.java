package com.john.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/14
 */
public class NotifyEvent extends ApplicationEvent {


	private String email;

	private String content;

	public NotifyEvent(Object source) {
		super(source);
	}

	public NotifyEvent(Object source, String email, String content) {
		super(source);
		this.email = email;
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// 省略getter/setter方法
}
