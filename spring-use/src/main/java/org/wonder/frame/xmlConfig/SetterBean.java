package org.wonder.frame.xmlConfig;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/16
 */
public class SetterBean {

	public interface IService {} //@1


	public static class ServiceA implements IService {} //@2

	public static class ServiceB implements IService {} //@

	private IService service;

	public void setService(IService service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "SetterBean{" +
				"service=" + service +
				'}';
	}
}
