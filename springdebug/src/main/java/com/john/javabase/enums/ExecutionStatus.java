package com.john.javabase.enums;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/8/26
 */
public enum ExecutionStatus {

	SUCCESS (1), SKIPPED(-1), DISABLED(-2), FAILED(-3);

	private int status;

	ExecutionStatus(int status) {
		this.status = status;
	}
}
