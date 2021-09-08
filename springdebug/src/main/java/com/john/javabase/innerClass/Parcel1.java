package com.john.javabase.innerClass;

/**
 * @Description: 内部类示例1
 * @Author: johnwonder
 * @Date: 2021/6/19
 */
public class Parcel1 {

	class Contents{

		//普通内部类不能包含静态成员
		//private static  int j =0;
		private  int i = 11;

		private int value() {
			return i;
		}
		//普通内部类可以包含普通内部类
		class Remark{

			private int getRemark(){
				return  value();
			}

			class  People {

				private  int getPeopleRemark(){
					return  getRemark();
				}
			}
		}
		//普通内部类不能包含静态内部类
//		static class People{
//
//		}
	}
}
