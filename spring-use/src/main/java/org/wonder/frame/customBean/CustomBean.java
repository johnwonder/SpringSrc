/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wonder.frame.customBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.*;

/**
 * Simple test bean used for testing bean factories, the AOP framework etc.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Stephane Nicoll
 * @since 15 April 2001
 */
public class CustomBean implements BeanNameAware, BeanFactoryAware, ITestBean, IOther, Comparable<Object> {

	private String beanName;

	private InnerBean innerBean;

	private String country;

	private BeanFactory beanFactory;

	private boolean postProcessed;

	private String name;

	private String sex;

	private int age;

	private boolean jedi;

	private ITestBean spouse;

	protected ITestBean[] spouses;

	private String touchy;

	private String[] stringArray;

	private Integer[] someIntegerArray;

	private Integer[][] nestedIntegerArray;

	private int[] someIntArray;

	private int[][] nestedIntArray;

	private Date date = new Date();

	private Float myFloat = new Float(0.0);

	private Collection<? super Object> friends = new LinkedList<>();

	private Set<?> someSet = new HashSet<>();

	private Map<?, ?> someMap = new HashMap<>();

	private List<?> someList = new ArrayList<>();

	private Properties someProperties = new Properties();

	private boolean destroyed;

	private Number someNumber;


	private Boolean someBoolean;

	private List<?> otherColours;

	private List<?> pets;


	public CustomBean() {
	}

	public CustomBean(String name) {
		this.name = name;
	}

	public CustomBean(ITestBean spouse) {
		this.spouse = spouse;
	}

	public CustomBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public CustomBean(ITestBean spouse, Properties someProperties) {
		this.spouse = spouse;
		this.someProperties = someProperties;
	}

	public CustomBean(List<?> someList) {
		this.someList = someList;
	}

	public CustomBean(Set<?> someSet) {
		this.someSet = someSet;
	}

	public CustomBean(Map<?, ?> someMap) {
		this.someMap = someMap;
	}

	public CustomBean(Properties someProperties) {
		this.someProperties = someProperties;
	}


	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setPostProcessed(boolean postProcessed) {
		this.postProcessed = postProcessed;
	}

	public boolean isPostProcessed() {
		return postProcessed;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
		if (this.name == null) {
			this.name = sex;
		}
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	public boolean isJedi() {
		return jedi;
	}

	public void setJedi(boolean jedi) {
		this.jedi = jedi;
	}

	@Override
	public ITestBean getSpouse() {
		return this.spouse;
	}

	@Override
	public void setSpouse(ITestBean spouse) {
		this.spouse = spouse;
	}

	@Override
	public ITestBean[] getSpouses() {
		return (spouse != null ? new ITestBean[] {spouse} : null);
	}

	public String getTouchy() {
		return touchy;
	}

	public void setTouchy(String touchy) throws Exception {
		if (touchy.indexOf('.') != -1) {
			throw new Exception("Can't contain a .");
		}
		if (touchy.indexOf(',') != -1) {
			throw new NumberFormatException("Number format exception: contains a ,");
		}
		this.touchy = touchy;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String[] getStringArray() {
		return stringArray;
	}

	@Override
	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}

	@Override
	public Integer[] getSomeIntegerArray() {
		return someIntegerArray;
	}

	@Override
	public void setSomeIntegerArray(Integer[] someIntegerArray) {
		this.someIntegerArray = someIntegerArray;
	}

	@Override
	public Integer[][] getNestedIntegerArray() {
		return nestedIntegerArray;
	}

	@Override
	public void setNestedIntegerArray(Integer[][] nestedIntegerArray) {
		this.nestedIntegerArray = nestedIntegerArray;
	}

	@Override
	public int[] getSomeIntArray() {
		return someIntArray;
	}

	@Override
	public void setSomeIntArray(int[] someIntArray) {
		this.someIntArray = someIntArray;
	}

	@Override
	public int[][] getNestedIntArray() {
		return nestedIntArray;
	}

	@Override
	public void setNestedIntArray(int[][] nestedIntArray) {
		this.nestedIntArray = nestedIntArray;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getMyFloat() {
		return myFloat;
	}

	public void setMyFloat(Float myFloat) {
		this.myFloat = myFloat;
	}

	public Collection<? super Object> getFriends() {
		return friends;
	}

	public void setFriends(Collection<? super Object> friends) {
		this.friends = friends;
	}

	public Set<?> getSomeSet() {
		return someSet;
	}

	public void setSomeSet(Set<?> someSet) {
		this.someSet = someSet;
	}

	public Map<?, ?> getSomeMap() {
		return someMap;
	}

	public void setSomeMap(Map<?, ?> someMap) {
		this.someMap = someMap;
	}

	public List<?> getSomeList() {
		return someList;
	}

	public void setSomeList(List<?> someList) {
		this.someList = someList;
	}

	public Properties getSomeProperties() {
		return someProperties;
	}

	public void setSomeProperties(Properties someProperties) {
		this.someProperties = someProperties;
	}


	public Number getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(Number someNumber) {
		this.someNumber = someNumber;
	}

	public Boolean getSomeBoolean() {
		return someBoolean;
	}

	public void setSomeBoolean(Boolean someBoolean) {
		this.someBoolean = someBoolean;
	}

	public List<?> getOtherColours() {
		return otherColours;
	}

	public void setOtherColours(List<?> otherColours) {
		this.otherColours = otherColours;
	}

	public List<?> getPets() {
		return pets;
	}

	public void setPets(List<?> pets) {
		this.pets = pets;
	}


	/**
	 * @see org.springframework.tests.sample.beans.ITestBean#exceptional(Throwable)
	 */
	@Override
	public void exceptional(Throwable t) throws Throwable {
		if (t != null) {
			throw t;
		}
	}

	@Override
	public void unreliableFileOperation() throws IOException {
		throw new IOException();
	}
	/**
	 * @see org.springframework.tests.sample.beans.ITestBean#returnsThis()
	 */
	@Override
	public Object returnsThis() {
		return this;
	}

	/**
	 * @see org.springframework.tests.sample.beans.IOther#absquatulate()
	 */
	@Override
	public void absquatulate() {
	}

	@Override
	public int haveBirthday() {
		return age++;
	}


	public void destroy() {
		this.destroyed = true;
	}

	public boolean wasDestroyed() {
		return destroyed;
	}


	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || !(other instanceof CustomBean)) {
			return false;
		}
		CustomBean tb2 = (CustomBean) other;
		return (ObjectUtils.nullSafeEquals(this.name, tb2.name) && this.age == tb2.age);
	}

	@Override
	public int hashCode() {
		return this.age;
	}

	@Override
	public int compareTo(Object other) {
		if (this.name != null && other instanceof CustomBean) {
			return this.name.compareTo(((CustomBean) other).getName());
		}
		else {
			return 1;
		}
	}

	public InnerBean getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(InnerBean innerBean) {
		this.innerBean = innerBean;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
