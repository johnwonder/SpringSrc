package com.john.event;

import org.springframework.context.ApplicationListener;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/14
 */
public class NotifyListener implements ApplicationListener<NotifyEvent> {

	@Override
	public void onApplicationEvent(NotifyEvent event) {
		System.out.println("邮件地址：" + event.getEmail());
		System.out.println("邮件内容：" + event.getContent());
	}
}
