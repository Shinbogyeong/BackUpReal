package com.test.java.Inheritance2;

public class Ex51_Abstract {

	public static void main(String[] args) {
		
		//인터페이스 vs 추상클래스
		// - 둘 다 추상 메소드를 통해서 메소드를 강제 구현
		// - 구현 멤버도 물려주고 싶으면 추상 클래스를 사용해야한다. 인터페이스는 불가능(X)
		// - 용도가 다르다.
		// - 인터페이스가 더 많이쓰임  (인터페이스를 설계하는게 추상클래스 설계보다 생각해야할 경우의 수가 적다.)
	}
}


//컴퓨터가 갖춰야할 사용법들의 집합
interface Computer{
	
	public abstract void on();
	public abstract void off();
	
}

abstract class AComputer{
	
	public abstract void on();
	public abstract void off();
	
	private String serialNumber;
	private int weight;
	private int price;
	
	public void check() {
		System.out.println("바이러스 검사.");
	}
	
}


//class ASUS100 implements Computer{
class ASUS100 extends AComputer{
	
//	private String serialNumber;
//	private int weight;
//	private int price;
//	
//	public void check() {
//		System.out.println("바이러스 검사.");
//	}

	@Override
	public void on() {
		//추상 메소드의 의도??
		// - 겉으로 보이는 사용법을 강제
		// - 구현부는 자유롭게 맘대로 > 되도록 ON이름에 걸맞는 행동을 구현하는걸 권장
		
		//System.out.println("ASUS100맘대로!!");
		
		System.out.println("전원 On");
	}

	@Override
	public void off() {
		System.out.println("전원 Off");
	}
	
}

//class Samsung200 implements Computer{
class Samsung200 extends AComputer{	

//	private String serialNumber;
//	private int weight;
//	private int price;
//	
//	public void check() {
//		System.out.println("바이러스 검사.");
//	}

	@Override
	public void on() {
		System.out.println("Power On");
	}

	@Override
	public void off() {
		System.out.println("Power Off");
	}
	
}


