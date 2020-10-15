package com.john.beanFactory;

/**
 * @author johnwonder
 * @version 1.0
 * @date 2020/10/15 8:27
 */
public class User {

	private Enum<City> ss;

	private City cc;

	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Enum<City> getSs() {
		return ss;
	}

	public City getCc() {
		return cc;
	}

	public void setCc(City cc) {
		this.cc = cc;
	}

	public void setSs(Enum<City> ss) {
		this.ss = ss;
	}

	@Override
	public String toString() {
		return "User{" +
				"ss=" + ss +
				", cc=" + cc +
				'}';
	}
}
