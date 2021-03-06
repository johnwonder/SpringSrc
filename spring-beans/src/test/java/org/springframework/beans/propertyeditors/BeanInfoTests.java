/*
 * Copyright 2002-2015 the original author or authors.
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

package org.springframework.beans.propertyeditors;

import java.beans.*;

import org.junit.Test;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * @author Juergen Hoeller
 * @since 06.03.2006
 */
public class BeanInfoTests {

	//https://blog.csdn.net/u010445297/article/details/60967146
	@Test
	public void testComplexObject() {
		ValueBean bean = new ValueBean();
		BeanWrapper bw = new BeanWrapperImpl(bean);
		Integer value = new Integer(1);


		//Integer value2 = new Integer(11);
//		bw.setPropertyValue("value", value);
//		System.out.println(bean.getValue());
//		assertEquals("value not set correctly", bean.getValue(), value);
//
//		value = new Integer(2);
//		bw.setPropertyValue("value", value.toString());
//		assertEquals("value not converted", bean.getValue(), value);
//
//		bw.setPropertyValue("value", null);
//		assertNull("value not null", bean.getValue());
//
//		bw.setPropertyValue("value", "");
//		System.out.println(bean.getValue());
//		assertNull("value not converted to null", bean.getValue());
//
//		bw.setPropertyValue("value","1");

		bw.setPropertyValue("user","john");

		bw.setPropertyValue("user","john");



		UserBean user =(UserBean)bw.getPropertyValue("user");
		System.out.println(user.getName());
	}


	public static class ValueBean {

		private Integer value;

		private UserBean user;

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public UserBean getUser() {
			return user;
		}

		public void setUser(UserBean user) {
			this.user = user;
		}
	}

	public static class UserBean{

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}


	//这个还是根据Bean名称去找到的
	public static class ValueBean1BeanInfo extends SimpleBeanInfo {

		@Override
		public PropertyDescriptor[] getPropertyDescriptors() {
			try {
				PropertyDescriptor pd = new PropertyDescriptor("value", ValueBean.class);
				pd.setPropertyEditorClass(MyNumberEditor.class);

				PropertyDescriptor userPd = new PropertyDescriptor("user", ValueBean.class);
				//写了也没用
				//userPd.setPropertyEditorClass(UserBeanEditor.class);

				return new PropertyDescriptor[] {pd,userPd};
			}
			catch (IntrospectionException ex) {
				throw new FatalBeanException("Couldn't create PropertyDescriptor", ex);
			}
		}
	}


	public static class UserBeanEditor extends PropertyEditorSupport {

		@Override
		public String getAsText() {
			return super.getAsText();
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {

			UserBean userBean = new UserBean();
			userBean.setName(text);
			super.setValue(userBean);
		}
	}

	public static class MyNumberEditor extends CustomNumberEditor {

		private Object target;

		public MyNumberEditor() throws IllegalArgumentException {
			super(Integer.class, true);
		}

		public MyNumberEditor(Object target) throws IllegalArgumentException {
			super(Integer.class, true);
			this.target = target;
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Assert.isTrue(this.target instanceof ValueBean, "Target must be available");
			super.setAsText(text);
		}

	}

}
