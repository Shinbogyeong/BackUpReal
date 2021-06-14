package com.test.java.Inheritance2;


//모니터 제품 - 실제 제품
public class HP200 implements Monitor{

	//모니터 특성
	private String name;
	private int power;
	private String color;
	
	//모니터 행동
//	public void begin() {
//		System.out.println("HP200 power on");
//	}
//	
//	public void end() {
//		System.out.println("HP200 power off");
//	}

	@Override
	public void powerOn() {
		System.out.println("HP200 power on");
	}

	@Override
	public void powerOff() {
		System.out.println("HP200 power off");
	}
}
