package com.john.propertyEditor;


import com.sun.beans.editors.StringEditor;

import java.beans.*;

/**
 * @author johnwonder
 * @version 1.0
 * @date 2020/10/10 15:56
 */
public class PropEditor {
	public static void main (String[] args) {

		PropertyEditor editor = PropertyEditorManager.findEditor(User.class);
		editor.setAsText("Joe1");
		System.out.println(editor.getValue());
	}

//	public static class UserBeanInfo extends SimpleBeanInfo {
//		private UserEditor userEditor = new UserEditor();
//
//		@Override
//		public PropertyDescriptor[] getPropertyDescriptors () {
//			try {
//				PropertyDescriptor propertyDescriptor
//						= new PropertyDescriptor("name", User.class) {
//					@Override
//					public PropertyEditor createPropertyEditor (Object bean) {
//						return userEditor;
//					}
//				};
//
//				return new PropertyDescriptor[]{propertyDescriptor};
//
//			} catch (IntrospectionException e) {
//				throw new RuntimeException(e);
//			}
//		}
//	}

	public static class UserEditor extends StringEditor {

		@Override
		public String getAsText () {
			User user = (User) getValue();
			return user.getName();
		}

		@Override
		public void setAsText (String s) {
			User user = new User();
			user.setName(s);
			setValue(user);
		}
	}

	public static class User {
		private String name;


		public String getName () {
			return name;
		}

		public void setName (String name) {
			this.name = name;
		}

		@Override
		public String toString () {
			return "User{" +
					"name='" + name + '\'' +
					'}';
		}
	}
}
