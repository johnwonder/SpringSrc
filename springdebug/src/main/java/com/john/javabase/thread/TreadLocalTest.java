package com.john.javabase.thread;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/2/13
 */
public class TreadLocalTest {
	private static ThreadLocal seqNum = new ThreadLocal() {
		public A initialValue(){
			return new A();
		}
	};
	public A getA(){
// seqNum.set(seqNum.get());
		return (A) seqNum.get();
	}
	public static void main(String[] args){
		TreadLocalTest sn = new TreadLocalTest();
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		TestClient t4 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	private static class TestClient extends Thread {
		private TreadLocalTest sn;
		public TestClient(TreadLocalTest sn){
			this.sn = sn;
		}
		public void run(){
			for(int i=0;i<3;i++){
				System.out.println("thread["+Thread.currentThread().getName()
						+"]sn["+sn.getA().hashCode()+"]");
			}
		}
	}

	public static class A {
	}

}
