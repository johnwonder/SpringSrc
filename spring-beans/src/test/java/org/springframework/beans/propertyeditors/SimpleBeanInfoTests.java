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

import org.junit.Test;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Juergen Hoeller
 * @since 06.03.2006
 */
public class SimpleBeanInfoTests {

	//https://blog.csdn.net/qq_35029061/article/details/86664795
	@Test
	public void testComplexObject() {

//		PropertyEditor editor = PropertyEditorManager.findEditor(ValueBean.class);
//		editor.setAsText("1");
//		System.out.println(editor.getValue());

		try{
			BeanInfo beanInfo = Introspector.getBeanInfo(ValueBean.class);

			ValueBean valueBean = new ValueBean();
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors() ;
			for (PropertyDescriptor pd : pds) {
				Method writeMethod = pd.getWriteMethod() ;

				String methodName = writeMethod.getName() ;
				try{
					Object result = writeMethod.invoke(valueBean,1) ;
					System.out.println(methodName + "-->" + result);
				}catch (InvocationTargetException e){

				}
				catch (IllegalAccessException e){

				}

			}
			for (PropertyDescriptor pd : pds) {
				Method writeMethod = pd.getWriteMethod() ;
				Method method = pd.getReadMethod() ;
				String methodName = method.getName() ;
				try{
					Object result = method.invoke(valueBean) ;
					System.out.println(methodName + "-->" + result);
				}catch (InvocationTargetException e){

				}
				catch (IllegalAccessException e){

				}

			}
		}
		catch (IntrospectionException e){

		}
	}


	public static class ValueBean {

		private Integer value;

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}
	}


	public static class ValueBeanBeanInfo extends SimpleBeanInfo {

		@Override
		public PropertyDescriptor[] getPropertyDescriptors() {
			try {
				PropertyDescriptor pd = new PropertyDescriptor("value", ValueBean.class);
				//pd.setPropertyEditorClass(ValueBeanEditor.class);
				return new PropertyDescriptor[] {pd};
			}
			catch (IntrospectionException ex) {
				throw new FatalBeanException("Couldn't create PropertyDescriptor", ex);
			}
		}
	}

	public static class ValueBeanEditor extends CustomNumberEditor {

		private Object target;

		public ValueBeanEditor() throws IllegalArgumentException {
			super(Integer.class, true);
		}

		public ValueBeanEditor(Object target) throws IllegalArgumentException {
			super(Integer.class, true);
			this.target = target;
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Assert.isTrue(this.target instanceof BeanInfoTests.ValueBean, "Target must be available");
			super.setAsText(text);
		}
	}

}
