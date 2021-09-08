package com.john.javabase.iface;

/**
 * @Description: 一个JAVA文件只有一个public标注的 类或者接口，你想要加public 就创建个和接口同名的java文件
 * @Author: johnwonder
 * @Date: 2021/6/5
 */
public interface Instrument {
}

abstract  class Wind implements  IParentDefaultMethod{

	//不加public会报错
	public  abstract String getName();
}

interface IParentDefaultMethod {

	String getName();
}


interface DefaultMethodInterface extends IParentDefaultMethod  {

	////默认方法与接口抽象方法定义相同:默认方法会优先于接口抽象方法,接口定义的方法会被忽略;
	//？？？
	//https://www.cnblogs.com/yanbinfeng1995/p/13826126.html
	 default String getName(){
		return  "john";
	}

	//String getName();
}
