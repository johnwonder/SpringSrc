package org.wonder.frame.constructorAutowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/15
 */
@Component
public class ContructorA {

	private final ConstructB constructB;
	private final Map<ConstructB,String> constructBs;

	private final ConstructC constructC;
	//调用了默认构造器
//	public ContructorA() {
//		this.constructB = new ConstructB();
//		this.constructC = null;
//	}
//	@Autowired
//	public ContructorA(ConstructB constructB) {
//		this.constructB = constructB;
//		this.constructC = null;
//	}

	public ContructorA(Map<ConstructB,String> constructB) {
		this.constructBs = constructB;
		this.constructC = null;
		this.constructB = null;
	}


//	public ContructorA(ConstructB constructB,ConstructC constructC) {
//		this.constructB = constructB;
//		this.constructC = constructC;
//	}


	@Override
	public String toString() {
		return "ContructorA{" +
				"constructB=" + constructB +
				", constructBs=" + constructBs +
				", constructC=" + constructC +
				'}';
	}
}
