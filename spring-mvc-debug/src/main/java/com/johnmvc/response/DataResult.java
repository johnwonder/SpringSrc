package com.johnmvc.response;

import java.io.Serializable;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/27
 */
public class DataResult<T> implements Serializable {
	private static final long serialVersionUID = 632481359614280127L;
	private T data;

	private boolean success;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
