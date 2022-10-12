package org.wonder.frame.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/5/6
 */
@Component
public class QualifiedTestBean {

	@TestQualifier
	@Autowired
	private Person qualified;

	private Person nonqualified;

	@Override
	public String toString() {
		return "QualifiedTestBean{" +
				"qualified=" + qualified +
				", nonqualified=" + nonqualified +
				'}';
	}
}
